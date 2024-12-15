package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	  @PostMapping("/create")
	    public Employee createEmployee(@RequestBody Employee employee) {
		  
	        return  employeeService.saveEmployee(employee);
	    }
	  
	  
	  @GetMapping("/employeelist")
	  public List<Employee> employeeLists(){
		  return employeeService.listAllEmployee();
	  }
	  
	  
	  @GetMapping("/employee/{id}")
	  public Optional<Employee> employeeList(@PathVariable("id")Long id){
		  return employeeService.getParticularEmployee(id);
	  }
	  
	  @PutMapping("/employeeupdate/{id}")
	  public Employee updateemployee(@PathVariable("id")Long id,@RequestBody Employee employee){
		  
		  return employeeService.updateEmployee(id,employee);
	  }
	  

	    @DeleteMapping("/delete/{id}")
	    public String  deleteEmployee(@PathVariable Long id) {
	        return this.employeeService.deleteEmployee(id) ;
	    }
	  
}
