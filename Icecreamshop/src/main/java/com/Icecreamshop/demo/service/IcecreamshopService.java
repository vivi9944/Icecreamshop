package com.Icecreamshop.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Icecreamshop.demo.model.Icecreamshop;
import com.Icecreamshop.demo.repository.IcecreamshopRepository;







@Service
public class IcecreamshopService {

	@Autowired
	IcecreamshopRepository IcecreamshopService;
	
	public List<Icecreamshop> getAllIcecreamshop()
	{
		List<Icecreamshop>icecreamshopList=IcecreamshopService.findAll();
		return icecreamshopList;
	}
	public Icecreamshop saveIcecreamshop(Icecreamshop i)
	{
		return IcecreamshopService.save(i);
	}
	public  Icecreamshop updateIcecreamshop(Icecreamshop i,int iteamno) {
		Optional<Icecreamshop> optional=IcecreamshopService.findById(iteamno);
		Icecreamshop obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setIteamno(i.getIteamno());
			obj.setIteamname(i.getIteamname());
			obj.setIteamflavour(i.getIteamflavour());
			obj.setIteamcost(i.getIteamcost());
		IcecreamshopService.saveAndFlush(i);
		}
		return obj;
	}
	public void deleteIcecreamshop(int i) 
	{
		IcecreamshopService.deleteById(i);
	}
	public List<Icecreamshop>sortIcecreamshop(String field)
	{
		return IcecreamshopService.findAll(Sort.by(Direction.DESC,field));
	}
	public List<Icecreamshop>pagingIcecreamsshop(int offset,int pageSize){
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Icecreamshop>icecreamshopData=IcecreamshopService.findAll(paging);
		List<Icecreamshop>icecreamshopList=icecreamshopData.getContent();
		return icecreamshopList;
	}
	public List<Icecreamshop> pagingAndSortingIcecreamshops(int offset,
			int pageSize,String field) {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
			Page<Icecreamshop> icecreamshop=IcecreamshopService.findAll(paging);
			return icecreamshop.getContent();
		}
	public List<Icecreamshop> fetchStudentsByIteamnamePrefix(String prefix)
	  {
		  return IcecreamshopService.findByIteamnameStartingWith(prefix);
	  }
	public List<Icecreamshop>getStudentsByIteamcolour(String colour,String name)
	{
		return IcecreamshopService.getStudentsByIteamcolour(colour,name);
	}
}
	
