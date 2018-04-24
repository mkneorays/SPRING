package com.neorays.service;

import java.util.List;

import com.neorays.command.LoginCommand;
import com.neorays.dto.EmpInsertDTO;
import com.neorays.dto.LoginDTO;
import com.neorays.dto.RegisterDTO;

public interface EmployeeService {

	public String registerEmp(RegisterDTO dto) throws Exception; 
	public String loginEmp(LoginDTO dto) throws Exception; 
	public String insertEmp(EmpInsertDTO dto);
	public List<EmpInsertDTO> selectEmp();
	public String deleteEmp(int eid);
	public List<RegisterDTO> loginCred();
	public static final int PAGE_SIZE=4;
	public  int getPageCount();
	public List<EmpInsertDTO> getReportData(int pageNo);
}
