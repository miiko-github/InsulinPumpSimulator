package com.fh.his.insulincontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import com.fh.his.dao.BloodGlucoseReadings;
import com.fh.his.dao.HibernateChecker;
import com.fh.his.gui.Clock;
import com.itextpdf.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.prism.paint.Color;



public class ReportManager {
	
	private static ReportManager reportmanager;
	
	public static void generateReport(){
		long start = System.currentTimeMillis();
		
		StringBuilder filename = new StringBuilder("D:\\InsulinAndBloodGlucoseReport.pdf");
//	filename.append(Clock.getInstance().getCurrentFormattedDate().concat(".pdf"));
		Document document = new Document();
		OutputStream file;
		try {
			file = new FileOutputStream(new File(filename.toString()));
		
		PdfWriter.getInstance(document, file);
		 document.open();
	        document.add(new Paragraph("Insulin Pump Simulator Report"));
	        //document.add(new Paragraph(new Date().toString()));
	        document.add(new Paragraph(""));
		PdfPTable table = new PdfPTable(2);
		table.setHeaderRows(2);
		
		PdfPCell cell1 = new PdfPCell(new Paragraph("Date"));
		cell1.setBorderWidth(1f);
		cell1.setUseBorderPadding(true);
		cell1.setBorderColor(BaseColor.BLACK);
        PdfPCell cell2 = new PdfPCell(new Paragraph("Blood Sugar level"));
        cell2.setBorderColor(BaseColor.BLACK);
        cell2.setUseBorderPadding(true);
        cell2.setBorderWidth(1f);
  //      PdfPCell cell3 = new PdfPCell(new Paragraph("Insulin Dosage"));

        table.addCell(cell1);
        table.addCell(cell2);
     //   table.addCell(cell3);
		
		List li = HibernateChecker.getBloodGlucoseHistory();
		 
		for(int i =li.size()-1; i>=0;i--){
			BloodGlucoseReadings bgr= (BloodGlucoseReadings) li.get(i);
			PdfPCell cell3 = new PdfPCell(new Paragraph(bgr.getTime()));
			cell3.setBorderWidth(1f);
			cell3.setUseBorderPadding(true);
			
			cell3.setBorderColor(BaseColor.BLACK);
	        PdfPCell cell4 = new PdfPCell(new Paragraph(bgr.getReadings()));
	        cell4.setBorderColor(BaseColor.BLACK);
	        cell4.setBorderWidth(1f);
	        cell4.setUseBorderPadding(true);
	        table.addCell(cell3);
	        table.addCell(cell4);
		}
		document.add(table);
		document.setPageCount(1);
		document.addCreationDate();
		document.addTitle("Insulin Pump Simulator");
		 document.close();
	        file.close();
	        
	        System.out.println("total time "+(System.currentTimeMillis()-start));
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		
		/*try {
			Document document = new Document();
			FileOutputStream file = new FileOutputStream(new File("D:\\Test.pdf"));
			PdfWriter.getInstance(document, file);
			 document.open();
		        document.add(new Paragraph("Hello World, iText"));
		        document.add(new Paragraph(new Date().toString()));

		        document.close();
		        file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
        
        catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	//	generateReport(1);
	
       
	}
	public static ReportManager getInstance(){
		if (reportmanager==null){
			reportmanager= new ReportManager();
		}
		return reportmanager;
	}
	
	

}
