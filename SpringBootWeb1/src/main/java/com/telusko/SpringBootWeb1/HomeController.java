package com.telusko.SpringBootWeb1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController 
{
	@GetMapping("/")
	public String home()
	{
		System.out.println("Home controller called!");
		return "index";
	}
	//This is servlet way 
	/*
	@GetMapping("/add")
	public String add(HttpServletRequest req,HttpSession session)
	{
		int n1 = Integer.parseInt(req.getParameter("num1"));
		int n2 = Integer.parseInt(req.getParameter("num2"));
		
		int result = n1+n2;
		session.setAttribute("result", result);
		System.out.println(result);
		return "result.jsp";
	}
	*/
	
	//This is how we do in spring
	/*
	@GetMapping("add")
	public String add(@RequestParam("num1") int n1,@RequestParam("num2") int n2,HttpSession session) 
	{
		int result=n1+n2;
		session.setAttribute("result", result);

		return "result.jsp";
	}
	*/
	
	//using model attribute
	
	@GetMapping("add")
	public String add(@RequestParam("num1") int n1,@RequestParam("num2") int n2, Model model) 
	{
		int result=n1+n2;
		model.addAttribute("result", result);

		return "result";
	}
}
