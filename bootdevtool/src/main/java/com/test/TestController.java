package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController 
{
	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		int a = 6;
		int b = 9;
		
		return "Testing... Sum of a + b = " + (a+b);
	}
}
