package com.example.chtgamework;

import java.io.Serializable;

public class Hero implements Serializable{//
	private int    hero_icon;
	private String name;
	private String price;
	private String hero_sign;
	private int    blood;
	public Hero() {
		super();
	}
	public Hero(int hero_icon, String name, String price, String hero_sign,
			int blood) {
		super();
		this.hero_icon = hero_icon;
		this.name = name;
		this.price = price;
		this.hero_sign = hero_sign;
		this.blood = blood;
	}
	public int getHero_icon() {
		return hero_icon;
	}
	public void setHero_icon(int hero_icon) {
		this.hero_icon = hero_icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getHero_sign() {
		return hero_sign;
	}
	public void setHero_sign(String hero_sign) {
		this.hero_sign = hero_sign;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	

}

