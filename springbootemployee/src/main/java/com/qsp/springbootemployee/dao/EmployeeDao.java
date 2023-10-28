package com.qsp.springbootemployee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.repo.EmployeeRepo;

@Repository
public class EmployeeDao 
{
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee employee) 
	{
		return repo.save(employee);
	}

	public Employee findEmployee(int id) 
	{
//		return repo.findById(id).get();
		
		//To avoid NoSuchElementException
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<Employee> findAllEmployee()
	{
		return repo.findAll();
	}
	
	public Employee deleteEmployee(int id)
	{
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		} else {
			return null;
		}
	}
	
	public Employee updateEmployee(int id, Employee employee) 
	{
		Optional<Employee> optional = repo.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		else
		{
			employee.setId(id);
			return repo.save(employee);
		}
	}
	
	public Employee findByEmail(String email) 
	{
		return repo.findEmployeeByEmail(email);
	}
	
	public Employee getByPhone(long phone) 
	{
		return repo.getEmployeeByPhone(phone);
	}
	
	public Employee empByPhone(long phone)
	{
		return repo.empByPhone(phone);
	}
	
	public List<Employee> findBySalary(double salary)
	{
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}
	
	public List<Employee> findBySalaryL(double salary)
	{
		return repo.findEmployeeBySalaryLessThan(salary);
	}
}

