package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return (Employee) employeeRepository.save(employee);
		
	}

	public List<Employee> listAllEmployee() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getParticularEmployee(Long id) {
	
		return employeeRepository.findById(id);
	}

	public Employee updateEmployee(Long id, Employee employee) {
	    Optional<Employee> oldEmployee = this.employeeRepository.findById(id);

	    if (oldEmployee.isEmpty()) {
	        throw new ResourceNotFoundException("Employee not found with ID: " + id);
	    }

	    Employee existingEmployee = oldEmployee.get();

	    if (employee.getName() != null && !employee.getName().isEmpty()) {
	        existingEmployee.setName(employee.getName());
	    }
	    if (employee.getDepartment() != null && !employee.getDepartment().isEmpty()) {
	        existingEmployee.setDepartment(employee.getDepartment());
	    }
	    if (employee.getSalary() != null) {
	        existingEmployee.setSalary(employee.getSalary());
	    }

	    System.out.println("Updated successfully");
	    return this.employeeRepository.save(existingEmployee);
	}


	public String deleteEmployee(Long id) {
		this.employeeRepository.deleteById(id);
		return "Employee deleted Successfully";
	}

	

}
