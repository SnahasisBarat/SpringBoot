package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@RequestMapping("/customer")
	public String display(HttpServletRequest req,Model m)
	{
		String custId=req.getParameter("custId");
		String custName=req.getParameter("custName");
		String custPhn=req.getParameter("custPhn");
		String custAddr=req.getParameter("custAddr");
		String logId=req.getParameter("logId");
		String pass=req.getParameter("pass");
		
		m.addAttribute("cusId",custId);
		m.addAttribute("cusName",custName);
		m.addAttribute("cusPhn",custPhn);
		m.addAttribute("cusAddr",custAddr);
		m.addAttribute("cusLogin",logId);
	    m.addAttribute("cusPass",pass);
	    
	    return "customerWelcome";
	}
	
	

}
