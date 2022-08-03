package com.springboot.emp;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmpService {
	
	public String addEmployee(EmpEntity Employee) throws EmpExist;
	
	public List<EmpEntity> getEmployee();
	
	public EmpEntity updEmployee(EmpEntity Employee, int id) ;
}
