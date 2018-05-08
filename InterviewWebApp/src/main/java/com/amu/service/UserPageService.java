package com.amu.service;

import java.sql.SQLException;
import java.util.List;

import com.amu.beans.Users;
import com.amu.errors.DataBaseException;

public interface UserPageService {
	
	public String addUsers(Users user) throws DataBaseException;
	public List<Users> retrieve() throws  DataBaseException;
	public String deleteUser(String id) throws  DataBaseException;
	public String updateUser(String id,String name,String psw) throws  DataBaseException;
	public Users fetchUserById(String id) throws DataBaseException; 
	public List<Users> search(String search) throws  DataBaseException;
}//class
