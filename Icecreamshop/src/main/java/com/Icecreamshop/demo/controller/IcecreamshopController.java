package com.Icecreamshop.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Icecreamshop.demo.model.Icecreamshop;
import com.Icecreamshop.demo.service.IcecreamshopService;







@RestController
public class IcecreamshopController {
	
	@Autowired
	IcecreamshopService IcecreamshopController;
	
	@GetMapping("fetchalliteams")
	public List<Icecreamshop> getAllIcecreamshop()
	{
		List<Icecreamshop>icecreamshopList=IcecreamshopController.getAllIcecreamshop();
		return icecreamshopList;
	}
	@PostMapping("savealliteams")
	public Icecreamshop saveIcecreamshop(@RequestBody Icecreamshop i ) {
		return IcecreamshopController.saveIcecreamshop(i);
	}
	@PutMapping("/updateicecreamshop/{iteamno}")
	public  Icecreamshop updateIcecreamshop(@RequestBody Icecreamshop i,@PathVariable("iteamno") int iteamno)
	{	
		return IcecreamshopController.updateIcecreamshop(i,iteamno);
	}
	@DeleteMapping("deletealliteams/{id}")
	public void deleteIcecreamshop(@PathVariable("id") int id) 
	{
		IcecreamshopController.deleteIcecreamshop(id);
	}
	@GetMapping("/sortalliteams/{field}")
	public List<Icecreamshop>sortIcecreamshop(@PathVariable String field){
		return IcecreamshopController.sortIcecreamshop(field);
	}
	@GetMapping("/pagingicecreamshop/{offset}/{pageSize}")
	public List<Icecreamshop>pagingIcecreamshop(@PathVariable int offset,@PathVariable int pageSize)
	{
		return IcecreamshopController.pagingIcecreamsshop(offset,pageSize);
	}
	@GetMapping("/pagingAndSortingStudents/{offset}/{pageSize}/{field}")

	public List<Icecreamshop> pagingAndSortingEmployees(@PathVariable int offset,
			@PathVariable int pageSize,
			@PathVariable String field) 
	{
		return IcecreamshopController.pagingAndSortingIcecreamshops(offset, pageSize, field);
	}
	@GetMapping("/fetchStudentsByIteamnamePrefix")
	public List<Icecreamshop>fetchIcecreamshopByIteamnamePrefix(@RequestParam String prefix)
	{
		return IcecreamshopController.fetchStudentsByIteamnamePrefix(prefix);
	}
	@GetMapping("/fetchStudentsByIteamcolour/{colour}/{name}")
	public List<Icecreamshop>fetchStudentsByIteamcolour(@PathVariable String dept,@PathVariable String name)
	{
		return IcecreamshopController.getStudentsByIteamcolour(dept,name);
	}

}

	
