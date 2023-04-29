package com.Icecreamshop.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Icecreamshop.demo.model.Icecreamshop;



public interface IcecreamshopRepository extends JpaRepository <Icecreamshop,Integer> {


	//positional parameter
		@Query("select i from Icecreamshop i where i.iteamcolour=?1 and i.iteamname=?2")
		public List<Icecreamshop>getStudentsByIteamcolour(String colour,String name);

		//named parameter
		@Query("select i from Icecreamshop i where i.iteamcolour=:colour")
		public List<Icecreamshop>getStudentsByIteamcolour(String colour);
		
		
		//DML
		@Modifying
		@Query("delete from Icecreamshop i where i.iteamname=?1")
		public List<Icecreamshop>deleteStudentsByIteamname(String name);
		
		List<Icecreamshop> findByIteamnameStartingWith(String prefix);
		List<Icecreamshop> findByIteamnameEndingWith(String suffix);
		List<Icecreamshop> findByIteamcolour(String colour);
		List<Icecreamshop> findByIteamname(String name);
		
}

