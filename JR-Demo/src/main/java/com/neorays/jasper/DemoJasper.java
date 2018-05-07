package com.neorays.jasper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;





import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class DemoJasper {

	
	  @SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException,
	//logger.debug("Welcome in controller!");	

	JRException, IOException {
		/*
		 * JasperReport is the object that holds our compiled jrxml file
		 */
		JasperReport jasperReport;

		/*
		 * JasperPrint is the object contains report after result filling
		 * process
		 */
		JasperPrint jasperPrint;

		// connection is the data source we used to fetch the data from
		Connection connection = establishConnection();
		// jasperParameter is a Hashmap contains the parameters
		// passed from application to the jrxml layout
		HashMap jasperHashMap = new HashMap();
		jasperHashMap.put("ReportTitle", "Basic JasperReport");
		// jrxml compiling process
		jasperReport = JasperCompileManager
		// .compileReport("/JR-Demo/src/main/java/com/neorays/jrxml/sample_report.jrxml");
		// //its not working
		// .compileReport("com/neorays/jrxml/sample_report.jrxml"); //its not
		// working
				.compileReport("D://jrxml/sample_report.jrxml"); // its working

		// filling report with data from data source

		jasperPrint = JasperFillManager.fillReport(jasperReport,
				jasperHashMap, connection);

		// exporting process
		// 1- export to PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint,
				"D://report5.pdf");

		// 2- export to HTML
		JasperExportManager.exportReportToHtmlFile(jasperPrint,
				"D://report5.html");

		// 3- export to Excel sheet
		JRXlsExporter exporter = new JRXlsExporter();
		/*OutputStream ouputStream
	    = new FileOutputStream(new File("D:/catalog1.xls"));
	ByteArrayOutputStream byteArrayOutputStream
	    = new ByteArrayOutputStream();
		
		JRXlsExporter exporterXLS = new JRXlsExporter();
		exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,
				jasperPrint);
		exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
		                         byteArrayOutputStream);
		exporterXLS.exportReport();
		ouputStream.write(byteArrayOutputStream.toByteArray()); 
		ouputStream.flush();
		ouputStream.close();*/
		
		/*exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "D://report3.xls"); 
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE); 
		exporter.exportReport(); */
        
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
				"D://report5.xls");
		exporter.exportReport();
	}// main method

	public static Connection establishConnection()
			throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			String postgreURL = "jdbc:postgresql:neorays";
			connection = DriverManager.getConnection(postgreURL, "postgres",
					"POSTGRASQL");
			connection.setAutoCommit(false);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return connection;

	}
}// class

/*
 * <![CDATA[select item_name,item_amount from item where item_amount <=500000]]>
 */