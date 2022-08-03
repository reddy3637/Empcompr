package com.springboot.emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpImpl implements EmpService {
	
	@Autowired
	private EmpRepository EmpRepository;
	
	@Override
	public String addEmployee(EmpEntity Employee) {
		EmpEntity clearEmpData = EmpRepository.findByName(Employee.getName());
		if (clearEmpData == null)
		{
			EmpRepository.save(Employee);
			return "New Employee Added to the Database";}
		else 
			throw new EmpExist ("EmployeeData Already Existed in the Database");
	}

	@Override
	public EmpEntity updEmployee(EmpEntity Employee, int id)
	{
		Optional<EmpEntity> ed = EmpRepository.findById(id);
		EmpEntity eda = ed.get();
		eda.setName(Employee.getName());
		eda.setSalary(Employee.getSalary());
		eda.setDesignation(Employee.getDesignation());
		EmpRepository.save(eda);
		return eda;}
	
	@Override
	public List<EmpEntity> getEmployee(){
		return EmpRepository.findAllBySalary();}
}
