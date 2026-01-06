package com.codedecode.aopdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.aopdemo.entity.Employee;

@Repository 
public interface EmployeeRepo extends JpaRepository<Employee, Long>
{
	
}

