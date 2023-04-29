package com.Icecreamshop.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Icecreamshop {

	@Id
	private int iteamno;
	private String iteamname;
	private String iteamflavour;
	private int iteamcost;
	private String iteamcolour;
	public int getIteamno() {
		return iteamno;
	}
	public void setIteamno(int iteamno) {
		this.iteamno = iteamno;
	}
	public String getIteamname() {
		return iteamname;
	}
	public void setIteamname(String iteamname) {
		this.iteamname = iteamname;
	}
	public String getIteamflavour() {
		return iteamflavour;
	}
	public void setIteamflavour(String iteamflavour) {
		this.iteamflavour = iteamflavour;
	}
	public int getIteamcost() {
		return iteamcost;
	}
	public void setIteamcost(int iteamcost) {
		this.iteamcost = iteamcost;
	}
	public String getIteamcolour() {
		return iteamcolour;
	}
	public void setIteamcolour(String iteamcolour) {
		this.iteamcolour = iteamcolour;
	}
		
}
