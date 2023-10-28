package com.qsp.springbootemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.exception.DataNotFound;
import com.qsp.springbootemployee.exception.EmailNotFound;
import com.qsp.springbootemployee.exception.IdNotFound;
import com.qsp.springbootemployee.exception.NoDataAvailable;
import com.qsp.springbootemployee.exception.PhoneNotFound;
import com.qsp.springbootemployee.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) 
	{
		double salary = employee.getSalary();
		if (salary<10000) {
			employee.setGrade('A');
		} else if (salary>=10000 && salary<20000) {
			employee.setGrade('B');
		}else if (salary>=20000 && salary<40000){
			employee.setGrade('c');
		}else {
			employee.setGrade('D');
		}
		
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) 
	{
		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee!=null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {
			 throw new IdNotFound("Id Not Found");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee()
	{
		List<Employee> list = dao.findAllEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (list.isEmpty()) {
			throw new DataNotFound("Table is Empty");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return  new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		Employee employee = dao.deleteEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee!=null) {
			structure.setMessage("Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			 throw new IdNotFound("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, Employee employee) {
		double salary = employee.getSalary();
		if (salary<10000) {
			employee.setGrade('A');
		} else if (salary>=10000 && salary<20000) {
			employee.setGrade('B');
		}else if (salary>=20000 && salary<40000){
			employee.setGrade('c');
		}else {
			employee.setGrade('D');
		}
		Employee employee2 = dao.updateEmployee(id, employee);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee2!=null) {
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(employee2);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			 throw new IdNotFound("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		Employee employee = dao.findEmployee(id);
		employee.setEmail(email);
		Employee employee2 = dao.updateEmployee(id, employee);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee2!=null) {
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(employee2);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			 throw new IdNotFound("ID Not Found");


		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee = dao.findEmployee(id);
		employee.setPhone(phone);
		Employee employee2 = dao.updateEmployee(id, employee);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee2!=null) {
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(employee2);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFound("ID Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
		Employee employee = dao.findEmployee(id);
		employee.setSalary(salary);
		if (salary<10000) {
			employee.setGrade('A');
		} else if (salary>=10000 && salary<20000) {
			employee.setGrade('B');
		}else if (salary>=20000 && salary<40000){
			employee.setGrade('c');
		}else {
			employee.setGrade('D');
		}
		Employee employee2 = dao.updateEmployee(id, employee);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee2!=null) {
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(employee2);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFound("Id Not Found");

		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) 
	{
		Employee employee = dao.findByEmail(email);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee!=null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {
			throw new EmailNotFound("Email Not Found");

		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> getByPhone(long phone) 
	{
		Employee employee = dao.getByPhone(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee!=null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {
			throw new PhoneNotFound("Phone not found");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> empByPhone(long phone)
	{
		Employee employee = dao.empByPhone(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (employee!=null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {
			throw new PhoneNotFound("Phone Number Not Found");

		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalary(double salary)
	{
		List<Employee> list = dao.findBySalary(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (list.isEmpty()) {
			throw new NoDataAvailable("Data Not Found Between This Range");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryL(double salary)
	{
		List<Employee> list =  dao.findBySalaryL(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (list.isEmpty()) {
			throw new NoDataAvailable("Data Not Found Between This Range");

		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		}
	}
	
	
}
