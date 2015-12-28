package com.fh.his.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
private static SessionFactory sessionfactoy;

static{
	
	sessionfactoy = new AnnotationConfiguration().addAnnotatedClass(com.fh.his.dao.UserInformation.class).buildSessionFactory();
}

public static SessionFactory getSessionFactory(){
	return sessionfactoy;
}
}
