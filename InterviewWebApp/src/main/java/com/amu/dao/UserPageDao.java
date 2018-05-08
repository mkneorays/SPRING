package com.amu.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.amu.beans.Users;
import com.amu.errors.DataBaseException;

public interface UserPageDao {
	public int insertUsers(Users user) throws DataBaseException;

	public List<Users> selectUsers() throws DataBaseException;

	public int deleteUsers(String id) throws DataBaseException;

	public Users fetchUserById(String id) throws DataBaseException;

	public int updateUsers(String id, String name, String psw) throws DataBaseException;

	public List<Users> searchUsers(String search) throws DataBaseException;
}// class
