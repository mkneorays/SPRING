package com.neorays.dao;

import java.util.List;

public interface EmployeDAO {

	public List fetchEmp() ;
	public int insert(String name,int age,String add);
}// class
