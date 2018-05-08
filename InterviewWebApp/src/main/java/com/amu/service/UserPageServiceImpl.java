package com.amu.service;

import java.sql.SQLException;
import java.util.List;

import com.amu.beans.Users;
import com.amu.dao.UserPageDao;
import com.amu.dao.UserPageDaoImpl;
import com.amu.errors.DataBaseException;

public class UserPageServiceImpl implements UserPageService {

	//create dao class obj
	private UserPageDao dao=new UserPageDaoImpl();;
	
	public String addUsers(Users user) throws DataBaseException{
		//use dao method
		int result=dao.insertUsers(user);
		//write bussiness logic
		if(result==0)
			return "RECORD NOT INSERTED";
		else
			return "RECORD INSERTED";
	}//addUsers() method

	public List<Users> retrieve()throws  DataBaseException {
		List<Users> list=null;
		//use dao methods
		list=dao.selectUsers();
		return list;
	}//retrieve() method

	public String deleteUser(String id) throws DataBaseException {
		int result=0;
		//use dao method
		result=dao.deleteUsers(id);
	  //write business logic
		if(result==0)
			return "RECORD NOT DELETED";
		else
			return "RECORD DELETED";
	}//deleteUser method

	public String updateUser(String id,String name, String psw) throws DataBaseException {
           //call dao method
		int result=dao.updateUsers(id, name, psw);
		 //write business logic
				if(result==0)
					return "RECORD NOT UPDATED";
				else
					return "RECORD EDITED SUCCESSFULLY";
	}//updateUser method

	public List<Users> search(String search) throws DataBaseException {
		List<Users> list = null;
		//use dao method
		list=dao.searchUsers(search);
		return list;
	}//search method

	public Users fetchUserById(String id) throws DataBaseException {
	   //call dao method
		Users userById =dao.fetchUserById(id);
		return userById;
	}//fetchUserById method
}//class
