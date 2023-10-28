package com.qsp.springbootemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.service.EmployeeService;
import com.qsp.springbootemployee.util.ResponseStructure;

@RestController
public class MainController {
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) 
	{
		 return service.saveEmployee(employee);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@RequestParam int id) 
	{
		return service.findEmployee(id);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee()
	{
	 	return service.findAllEmployee();
	}

//	@DeleteMapping("/delete/{id}")
//	public Employee deleteEmployee(@PathVariable int id)
//	{
//		return dao.deleteEmployee(id);
//	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int id) 
	{
		return service.deleteEmployee(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id, @RequestBody Employee employee)
	{
		return service.updateEmployee(id, employee);
	}
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@RequestParam int id, @RequestParam String email) 
	{
		return service.updateEmail(id, email);
	}
	
	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@PathVariable int id, @RequestParam long phone) 
	{
		return service.updatePhone(id, phone);
	}
	
	@PatchMapping("/updateSalary")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@RequestParam int id, @RequestParam double salary) 
	{
		return service.updateSalary(id, salary);
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(@RequestParam String email) 
	{
		return service.findByEmail(email);
	}
	
	@GetMapping("/getByPhone")
	public ResponseEntity<ResponseStructure<Employee>> getByPhone(@RequestParam long phone) 
	{
		return service.getByPhone(phone);
	}
	
	@GetMapping("getPhone")
	public ResponseEntity<ResponseStructure<Employee>> empByPhone(@RequestParam long phone)
	{
		return service.empByPhone(phone);
	}
	
	@GetMapping("/findBySalary")
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalary(@RequestParam double salary)
	{
		return service.findBySalary(salary);
	}
	
	@GetMapping("/findBySalaryL")
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryL(@RequestParam double salary)
	{
		return service.findBySalaryL(salary);
	}
}
