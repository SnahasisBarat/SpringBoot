package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController {
	
	@Autowired
	customerRepo cust;
	
	@RequestMapping("/")
	public String display()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(customer cus)
	{
		cust.save(cus);
		return "index.jsp";
	}
	
	@RequestMapping("/getCustomer/{id}")
	public Optional<customer> getCustomer(@PathVariable int id)
	{
		
		return cust.findById(id);
	}
	
	@RequestMapping("/customers")
	public List<customer> getCustomers()
	{
		return cust.findAll();
	}
	
	@RequestMapping("/deleteCustomer{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		customer cu=cust.getOne(id);
		cust.delete(cu);
		return "deleted";
	}
	
	@RequestMapping("/updateCustomer/{id}")
	
	public customer updateCustomer(@PathVariable int id, @RequestBody customer cu)
	{
		cust.save(cu);
		return cu;
	}
	

}
