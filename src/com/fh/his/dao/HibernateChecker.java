package com.fh.his.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fh.his.insulincontroller.PrimeController;

public class HibernateChecker {
	
	private static SessionFactory sessionfactory;
	private static Session session;
	private static List timingandinsulinlist;
	@SuppressWarnings("deprecation")
	
	
	public static void setGlucoseData(BloodGlucoseReadings bgread){
		session= getInstance();
		
		session.getTransaction().begin();
		session.save(bgread);
		session.getTransaction().commit();
		session.close();
	}
	public static List getBasalProfiles() {
	//public static void main(String[] args){	
	HashMap<String, Date> basalprofile = new HashMap<String, Date>();
	List li = null;
		
		/*double updtedBg = 150- 200*(Math.exp(-(0.5*2.77/1.3)));
		System.out.println(updtedBg);
	System.out.println(Math.exp(0.65));*/
		try{
			//session = HibernateUtil.getSessionFactory().openSession();
		//	Configuration conf = new Configuration().configure();
		//	sessionfactory = conf.buildSessionFactory();
			session= getInstance();
			
		
			
	
		session.getTransaction().begin();
		
	/*	UserInformation user1 = new UserInformation();
		user1.setAge(24);
		user1.setGender("M");
		user1.setInsulin_type("1");
		user1.setName("Kameer Sheikh");		
		user1.setWeight(75);
		InsulinDosageReadings user1 = new InsulinDosageReadings("1234",new Date());
		session.save(user1);
		session.getTransaction().commit();
		//session.flush();
		
		session.close();*/
		
	//	}
		Query query = session.createQuery("select distinct basalProfileName from BasalProfile");
		
		li = query.list();
		/*for (int i=0; i<(li.size()/6); i++){
			query
		}*/
		
		Iterator<String> it = li.iterator();
		while(it.hasNext()){
		//	
			//System.out.println("sameer");
			System.out.println(it.next().toString());
			//BasalProfile user2 =(BasalProfile) it.next();
			//System.out.println(user2.getBasalProfileName());
			//basalprofile.put(user2.getBasalProfileName(), user2.getBasalprofilecreationdate());
		
		//System.out.println("profilename is: "+ user2.getBasalProfileName()+ "timing is: "+user2.getBasalStartTime()+"to "+user2.getBasalEndTime()+ "and insulin level "+ user2.getBasalInsulinDose());
		}
	//	session.getTransaction().commit();
	session.close();
		}
		catch(Exception e){
			
		}
		getActivatedBasalProfile();
		return li;
		
	}
	
	public static List getTimingsAndInsulin(String profilename){
		session= getInstance();
		
		session.getTransaction().begin();
		Query query = session.createQuery("from BasalProfile b where b.basalProfileName =:profilename");
		
		query.setParameter("profilename", profilename);
		List li = query.list();
		/*Iterator<BasalProfile> it = li.iterator();
		while(it.hasNext()){
			BasalProfile bp =it.next();
		
		}*/
		/*for (int i=0; i<(li.size()/6); i++){
			query
		}*/
	session.close();
		return li;			
	}
	public static void main(String[] args){
	getBasalProfiles();
		
		
	}
	
	public static void getActivatedBasalProfile(){
		long start = System.currentTimeMillis();
		session= getInstance();
		
		session.getTransaction().begin();
		Query queryprofile = session.createQuery("from BasalProfile b where b.basalProfileName =:profilename");
		Query query = session.createQuery("from BasalProfileStatus s where s.basalProfilestatus =:status");
		/*Query q= session.createSQLQuery("select * from BASAL_PROFILE b where b.pofile_name= (select profile_name from BASAL_PROFILE_STATUS s where s.status =:status)");
		q.setParameter("status", "ON");
		//System.out.println(q.list());
		List<BasalProfile> profilenamelist =q.list();
		System.out.println(profilenamelist);
		Iterator<BasalProfile> it = profilenamelist.iterator();
		while(it.hasNext()){
			
			System.out.println(it.next().getBasalStartTime()+" to " + it.next().getBasalEndTime());
		
		}*/
		
		query.setParameter("status", "ON");
		List<BasalProfileStatus> profilestatuslist = query.list();
		String profilename= profilestatuslist.iterator().next().getBasalProfileName();
		queryprofile.setParameter("profilename", profilename);
		
		List<BasalProfile> profilenamelist =queryprofile.list();
		//System.out.println(profilenamelist);
		//System.out.println(li);
		//"select * from BasalProfile b where n.basalProfileName= (select basalProfileName from BasalProfileStatus s where s.basalProfilestatus =:status)"
	/*	Iterator<BasalProfile> it = profilenamelist.iterator();
		while(it.hasNext()){
			BasalProfile bp =it.next();
			System.out.println(bp.getBasalStartTime()+" to " + bp.getBasalStartTime());
		
		}
		long end = System.currentTimeMillis();
		System.out.println("total duartion "+ ((end-start)/1000));*/
		/*for (int i=0; i<(li.size()/6); i++){
			query
		}*/
	session.close();
	PrimeController.setBasalprofilelist(profilenamelist);
		
	}
	
	public static Session getInstance(){
		Configuration conf = new Configuration().configure();
		sessionfactory = conf.buildSessionFactory();
		session= sessionfactory.openSession();
		return session;
	
	}
	public static List getInsulinDosageHistory(){
		session =getInstance();
		session.getTransaction().begin();
		Query query = session.createQuery("from InsulinDosageReadings");
		List insulindosehostory = query.list();
		session.close();
		return insulindosehostory;
	}
	
	public static List getBloodGlucoseHistory(){
		session =getInstance();
		session.getTransaction().begin();
		Query query = session.createQuery("from BloodGlucoseReadings");
		List bloodglucosestory = query.list();
		session.close();
		return bloodglucosestory;
	}

	public static void updateBasalProfileData(BasalProfile basalprofile) {
		session= getInstance();
		session.getTransaction().begin();
		Query query = session.createQuery("UPDATE BasalProfile set basalStartTime =:starttime,basalEndTime =:endtime,basalInsulinDose =:insulindose where basalProfileId =:profileid ");
		
		query.setParameter("starttime",basalprofile.getBasalStartTime() );
		query.setParameter("endtime",basalprofile.getBasalEndTime() );
		query.setParameter("insulindose",basalprofile.getBasalInsulinDose() );
		query.setParameter("profileid", basalprofile.getBasalProfileId());
		query.executeUpdate();
		session.getTransaction().commit();
		session.flush();
		session.close();
		getActivatedBasalProfile();
	}
	public static void setInsulinDosage(InsulinDosageReadings insulindosage) {
		session= getInstance();
		
		session.getTransaction().begin();
		session.save(insulindosage);
		session.getTransaction().commit();
		session.close();
		
	}
}
