package com.neorays.jasper;

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

public class DemoJasper {

	public static void main(String[] args) throws ClassNotFoundException,
			JRException {
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
		HashMap jasperParameter = new HashMap();

		// jrxml compiling process
		jasperReport = JasperCompileManager
				.compileReport("D://sample_report.jrxml");

		// filling report with data from data source

		jasperPrint = JasperFillManager.fillReport(jasperReport,
				jasperParameter, connection);

		// exporting process
		// 1- export to PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint,
				"D://report4.pdf");

		// 2- export to HTML
		JasperExportManager.exportReportToHtmlFile(jasperPrint,
				"D://report4.html");

		// 3- export to Excel sheet
		/*JRXlsExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"D://report3.xls");

		exporter.exportReport();*/
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


/*<![CDATA[select item_name,item_amount from item
where item_amount <=500000]]>*/