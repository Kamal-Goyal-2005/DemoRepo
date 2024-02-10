package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pogo.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {

	// creates an object with some reference to dummy obj
	@Autowired
	EmployeeRepo repo;

	Logger log = Logger.getAnonymousLogger();

	// insert
	public Employee insert(Employee e) {
		return repo.save(e);
	}

	// retrive
	public List<Employee> getAll() {
		return repo.findAll();
	}

	public void deleteEmployee(Employee e) {
		repo.delete(e);
	}

	public void deletebyId(Integer id) {
		repo.deleteById(id);
	}

	public Employee updateEmployee(Employee e) {
		// Optional<Employee> ee = repo.findById(e.getEmpno());
		Employee ee = repo.findById(e.getEmpno()).orElse(null);
		ee.setEname(e.getEname());
		log.info("Phone:" + e.getPhone());
		return repo.save(ee);
	}

	public Employee update(Employee e) {
		return repo.save(e);
	}

	public Optional<Employee> getbyId(Integer id) {
		return repo.findById(id);

	}

	public List<Employee> findbyname(String name) {
		return repo.findbyname(name);
	}

}
