package com.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entities.LoginData;
import com.practice.services.FormService;


@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model model) {
		System.out.println("opening form");
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	
	//handler for process form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			
			System.out.println(result);
			return "form";
		}
		
		System.out.println(loginData);
		//data process
		return "success";
	}
	
	
	FormService form;
	
	@GetMapping("/forms")
	public List<LoginData> getall()
	{
		return this.form.getall();
	}
	
	@GetMapping("/forms/{username}")
	public LoginData getOne(@PathVariable String username)
	{
		return this.form.getone(username);
	}
}
