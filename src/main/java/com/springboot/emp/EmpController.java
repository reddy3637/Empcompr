package com.springboot.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpService service;
    
    @PostMapping("/Employee")
    public String addEmployee(@RequestBody EmpEntity Employee) {
        return service.addEmployee(Employee);}

    @PutMapping("/Employee/{id}/{salary}")
    public EmpEntity updEmployee(@PathVariable double salary, @PathVariable int id, @RequestBody EmpEntity Employee) {
        return service.updEmployee(Employee, id);
    }

    @GetMapping("/getEmployee")
    public List<EmpEntity> getAllEmployee(){
        return service.getEmployee();
    }
    
    @ExceptionHandler(value = EmpExist.class)
	public ResponseEntity EmpExist(
			EmpExist EmpExist) {
		return new ResponseEntity("Employee already exists!", HttpStatus.CONFLICT);

    }
}
