package com.neorays.dao;

import java.util.List;

import com.neorays.domain.EmpInsertBO;
import com.neorays.domain.LoginBO;

public interface EmployeeDAO {

	public int loginInsert(LoginBO bo) throws Exception;
	public int authentaction(LoginBO bo) throws Exception;
	public int insertEmp(EmpInsertBO bo);
	public List<EmpInsertBO> selectEmp();
	public int deleteEmp(int eid);
	public List<LoginBO> loginCred();
	
	public long rowCount();
	public List<EmpInsertBO> getProducts(int startPos,int pageSize);

}//class
