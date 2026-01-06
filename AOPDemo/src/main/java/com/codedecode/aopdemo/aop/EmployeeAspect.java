package com.codedecode.aopdemo.aop;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.codedecode.aopdemo.entity.Employee;

@Aspect
@Component
public class EmployeeAspect 
{
	@Before(value="execution(* com.codedecode.aopdemo.controller.EmployeeController.*(..))")
	public void beforeAdvice(JoinPoint joinpoint)
	{
		System.out.println("Request to " + joinpoint.getSignature() +  " started at : " + new Date());
	}
	
	@After(value="execution(* com.codedecode.aopdemo.controller.EmployeeController.*(..))")
	public void afterAdvice(JoinPoint joinpoint)
	{
		System.out.println("Request to " + joinpoint.getSignature() +  " started at : " + new Date());
	}
	
	@Before(value="execution(* com.codedecode.aopdemo.service.EmployeeService.*(..))")
	public void beforeAdviceService(JoinPoint joinpoint)
	{
		System.out.println("Request to service " + joinpoint.getSignature() +  " started at : " + new Date());
	}
	
	@After(value="execution(* com.codedecode.aopdemo.service.EmployeeService.*(..))")
	public void afterAdviceService(JoinPoint joinpoint)
	{
		System.out.println("Request to service " + joinpoint.getSignature() +  " started at : " + new Date());
	}
	
	@AfterReturning(value="execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))", returning = "em")
	public void afterReturningAdviceForAddEmpService(JoinPoint joinpoint, Employee em)
	{
		System.out.println("Employee saved successfully with name : " + em.getName());
	}
	
	/*
	@AfterThrowing(value="execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))", throwing = "ex")
	public void afterThrowingAdviceForAddEmpService(JoinPoint joinpoint, Exception ex)
	{
		System.out.println("Exception occurred : " + ex.getMessage());
	}
	*/
	
	/*
	@Around(value="execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))")
	public void aroundAdviceForAddEmpService(ProceedingJoinPoint joinpoint) throws Throwable
	{
		System.out.println("Inside around advice, Logic to save employee started at : " + new Date());
		try
		{
			joinpoint.proceed();
		}
		catch(Exception e)
		{
			System.out.println("Inside around advice, Logic to save employee failed at : " + e.getMessage());
		}
		System.out.println("Inside around advice, Logic to save employee ended at : " + new Date());
	}
	*/
	
	/*
	@Around(value="execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))")
	public Employee aroundAdviceForAddEmpService(ProceedingJoinPoint joinpoint) throws Throwable
	{
		System.out.println("Inside around advice, Logic to save employee started at : " + new Date());
		try
		{
			Employee e = (Employee)joinpoint.proceed();
			return e;
		}
		catch(Exception e)
		{
			System.out.println("Inside around advice, Logic to save employee failed at : " + e.getMessage());
		}
		System.out.println("Inside around advice, Logic to save employee ended at : " + new Date());
		
		return null;
	}
	*/
	
	@Around(value="execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))")
	public Employee aroundAdviceForAddEmpService(ProceedingJoinPoint joinpoint) throws Throwable
	{
		System.out.println("Inside around advice, Logic to save employee started at : " + new Date());
		try
		{	
			Employee emp = new Employee();
		
			Employee[] arr = new Employee[1];
			emp.setName("Dummy");
			arr[0] = emp;
			
			Employee e = (Employee)joinpoint.proceed(arr);
			return e;
		}
		catch(Exception e)
		{
			System.out.println("Inside around advice, Logic to save employee failed at : " + e.getMessage());
		}
		System.out.println("Inside around advice, Logic to save employee ended at : " + new Date());
		
		return null;
	}
}
