package com.neorays.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neorays.bean.EmployeeBean;

public class EmployeeDAOImpl implements EmployeDAO {

	public static final String EMPLOYEE_DETAILS = "SELECT * FROM  EMP";
	public static final String EMPLOYEE_INSERT = "INSERT INTO EMPLOYEE VALUES (?,?,?)";
	
	static Connection con;
	static Statement st ;
	static PreparedStatement ps;
	static ResultSet rs;

	public static Connection getConnection() {
				try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:neorays",
					"postgres", "POSTGRASQL");
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}// getConnection() method

	public List fetchEmp() {
	
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		try {
			// get connection
			con = getConnection();

			st = con.createStatement();

			rs = st.executeQuery(EMPLOYEE_DETAILS);

			while (rs.next()) {
				EmployeeBean emp = new EmployeeBean();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getDate(5));
				emp.setComm(rs.getInt(6));
				emp.setDeptId(rs.getInt(7));
				list.add(emp);
			}// while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// fetch data
		return list;
	}// fetch method

	public int insert(String name, int age, String add) {
		int result=0;
		//get connection obj
		con=getConnection();
		//create  preparedStatement obj
		try {
			ps=con.prepareStatement( EMPLOYEE_INSERT );
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, add);
			//call execute method
		     result=ps.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return result;
	}//insert method

}// class
