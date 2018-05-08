package com.amu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amu.beans.Users;
import com.amu.errors.DataBaseException;

public class UserPageDaoImpl implements UserPageDao {

	static Connection con = null;
	private static final String USER_INSERT_QUERY = "INSERT INTO USERS VALUES(?,?,?)";
	private static final String USER_SELECT_QUERY = "SELECT * FROM USERS";
	private static final String USER_DELETE_QUERY = "DELETE FROM  USERS WHERE USER_ID=?";
	private static final String USER_UPDATE_QUERY = "UPDATE USERS SET NAME=?,PASSWORD=? WHERE USER_ID=?";
	private static final String USER_SEARCH_QUSERY = "SELECT * FROM USERS WHERE NAME LIKE '%?%'";
	private static final String USER_ID_QUERY = "SELECT * FROM USERS WHERE USER_ID=?";
 
	
	static {
		try {
			// register jdbc driver
			
			Class.forName("org.postgresql.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			// establish connection with db
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mom");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/neorays", "postgres", "POSTGRASQL");
		} catch (SQLException sql) {
			throw new DataBaseException("DATABASE NOT CONNECTED PLESE TRY AGAIN");
		} catch (ClassNotFoundException cnfe) {
			throw new DataBaseException("DATABASE NOT CONNECTED PLESE TRY AGAIN");
		}
	}// generate connection static method

	public int insertUsers(Users user) throws DataBaseException {
		PreparedStatement ps = null;
		int count = 0;
		// get connection obj
		try {
			ps = con.prepareStatement(USER_INSERT_QUERY);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPass());
			// call executeUpdate method
			count = ps.executeUpdate();
		} catch (SQLException sql) {
			sql.printStackTrace();
			throw new DataBaseException("DUPLICATE USERID NOT ALLOWED OR BAD CONNECTION PLESE TRY AGAIN");
		}
		return count;
	}//insertUsers method

	public List<Users> selectUsers() throws DataBaseException {
		List<Users> list = new ArrayList<Users>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// get PreparedStatement obj
			ps = con.prepareStatement(USER_SELECT_QUERY);
			rs = ps.executeQuery();
		} catch (SQLException sql) {
			sql.printStackTrace();
		
			throw new DataBaseException("DATABASE NOT CONNECTED PLESE TRY AGAIN");
		}
		try {
			// reterving data from resultSet
			while (rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPass(rs.getString(3));
				//add beans in list obj
				list.add(user);
			} // while
		} catch (SQLException sql) {
			sql.printStackTrace();
			throw new DataBaseException("DATABASE NOT CONNECTED PLESE TRY AGAIN");
		}
		return list;
	}//selectUsers method

	public int deleteUsers(String id) throws DataBaseException {
		PreparedStatement ps = null;
		int count = 0;
		try {
			//use connection obj
			ps = con.prepareStatement(USER_DELETE_QUERY);
			ps.setString(1, id);
			count = ps.executeUpdate();
		} catch (SQLException sql) {
			sql.printStackTrace();
			throw new DataBaseException("DATABASE NOT CONNECTED PLESE TRY AGAIN");
		}
		return count;
	}//deleteUsers method

	public Users fetchUserById(String id) throws DataBaseException {
		Users u = new Users();
		try {
			//crreate resultset obj
			PreparedStatement ps = con.prepareStatement(USER_ID_QUERY);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
             //retrive data from resulset obj
			while (rs.next()) {
				u.setName(rs.getString("NAME"));
				u.setPass(rs.getString("PASSWORD"));
				u.setUserId(rs.getString("USER_ID"));
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}
		
		return u;
	}//fetchUserById method

	public int updateUsers(String id, String name, String psw) throws DataBaseException {
		PreparedStatement ps = null;
		System.out.println(id+ "  "+name+" "+psw);
		int count = 0;
		try {
			//use prepareStatement
			ps = con.prepareStatement(USER_UPDATE_QUERY);
			ps.setString(1, name);
			ps.setString(2, psw);
			ps.setString(3, id);
			// call executeUpdate method
			count = ps.executeUpdate();
		} catch (SQLException sql) {
			sql.printStackTrace();
			throw new DataBaseException("DUBLICATE USERID NOT ALLOWED PLESE TRY AGAIN");
		}
		return count;
	}// method

	public List<Users> searchUsers(String search) throws DataBaseException {
		List<Users> list = new ArrayList<Users>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//use prepareStatement
			ps = con.prepareStatement("SELECT * FROM USERS WHERE NAME LIKE '%" + search + "%'");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException("NO SUCH USER FOUND OR BAD CONNECTION");
		}//catch
		try {
			//retreive data from ResultSet obj
			while (rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPass(rs.getString(3));
                //add beans in list collection
				list.add(user);
			}//while
		} catch (SQLException sql) {
			sql.printStackTrace();
			throw new DataBaseException("NO SUCH USER FOUND OR BAD CONNECTION");
		}//catch
		return list;
	}//searchUsers method

}// class

//alter table users alter column  password type character(20);
