package com.neorays.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neorays.dao.EmployeeDAO;
import com.neorays.domain.EmpInsertBO;
import com.neorays.domain.LoginBO;
import com.neorays.dto.EmpInsertDTO;
import com.neorays.dto.LoginDTO;
import com.neorays.dto.RegisterDTO;
@Service
public class EmployeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	
	public String registerEmp(RegisterDTO dto) throws Exception {
		
		LoginBO bo=null;
		//create bo obj
		bo=new LoginBO();
		//copy data dto to bo
		BeanUtils.copyProperties(dto, bo);
		//use dao class
		int count=dao.loginInsert(bo);
		//bussiness logic
		if(count!=0)
			return "REGSTERED SUCCESSFULL GO TO LOGIN";
		else
		return "NOT REGISTERED, PLEASE TRY AGAIN";
	}//registerEmp method


	public String loginEmp(LoginDTO dto) throws Exception {
		LoginBO bo=null;
		//create bo obj
		bo=new LoginBO();
		//copy data dto to bo
		bo.setName(dto.getUser());
		bo.setPsw(dto.getPsw());
		//use dao class
		int count=dao.authentaction(bo);
		//bussiness logic
		if(count==0)
			return "fail";
		else
		return "success";
		
	}//loginEmp method


	public String insertEmp(EmpInsertDTO dto) {
		
		EmpInsertBO bo=null;
		//create bo obj
		bo=new EmpInsertBO();
		//copy data dto to bo
		//copy data dto to bo
		BeanUtils.copyProperties(dto, bo);
		//use dao class
		int count=dao.insertEmp(bo);
		if(count==0)
			return "RECORD ARE NOT INSERTED";
		else
		return "RECORD ARE INSERTED";
	}//insertEmp method


	public List<EmpInsertDTO> selectEmp() {
		List<EmpInsertBO> listBO=null;
		//create ArrayList class obj
		List<EmpInsertDTO> listDTO=new ArrayList<EmpInsertDTO>();
		//use dao class
		listBO=dao.selectEmp();
		//convert listbo to listdto 
		for(EmpInsertBO bo:listBO){
			EmpInsertDTO dto=new EmpInsertDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		}//for loop
		
		return listDTO;
	}//selectEmp method


	public String deleteEmp(int eid) {
	   int result=0;
	 
	       //use dao
	       result=dao.deleteEmp(eid);
		if(result==0)
			return "Record Not Deleted Successfully";
		else 
			return "Record  Deleted Successfully";
		
	}//deleteEmp list


	public List<RegisterDTO> loginCred() {
		List<LoginBO> listBO;
		List<RegisterDTO> listDTO=null;
	   listDTO=new ArrayList<RegisterDTO>();
		//use dao
		listBO=dao.loginCred();
		
		//copy bo to dto
		for(LoginBO bo :listBO){
			RegisterDTO dto=new  RegisterDTO();
			BeanUtils.copyProperties(bo, dto);
			
			listDTO.add(dto);
		}//for loop
		return listDTO;
	}//loginCred


	public int getPageCount() {
		
		long rowCount=0;
		int pageCount=0;
		//use DAO
		rowCount=dao.rowCount();
		//calculate pagesCount
		pageCount=(int) (rowCount/EmployeeService.PAGE_SIZE);
		
		if(rowCount%EmployeeService.PAGE_SIZE!=0)
			pageCount++;
		return pageCount;
		
	}//getPageCount


	public List<EmpInsertDTO> getReportData(int pageNo) {
		 int startPos=0;
		 List<EmpInsertBO> listBO=null;
			//create ArrayList class obj
			List<EmpInsertDTO> listDTO=new ArrayList<EmpInsertDTO>();
		//Decide StartPosition to get page Report data based on given pageno
		startPos=(pageNo*EmployeeService.PAGE_SIZE)-EmployeeService.PAGE_SIZE;
		
		//use DAO
		listBO=dao.getProducts(startPos,EmployeeService.PAGE_SIZE);
		//convert listProduct to listDTO
		/*listProduct.forEach(p->{
			ProductDTO dto=null;
			dto=new ProductDTO();
			dto.setPid(p.getPid());
			dto.setPname(p.getPname());
			dto.setPrice(p.getPrice());
			dto.setQty(p.getQty());
			listDTO.add(dto);
		});*/
		for(EmpInsertBO bo:listBO){
			EmpInsertDTO dto=new EmpInsertDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		}//for loop
		return listDTO;
	
	}//getReportDate

	
}//class
