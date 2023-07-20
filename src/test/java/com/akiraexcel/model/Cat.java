package com.akiraexcel.model;

import com.github.boyundefeated.akiraexcel.annotation.ExcelColumnTitle;

public class Cat {

	@ExcelColumnTitle("name")
	private String name;

	@ExcelColumnTitle("age")
	private int age;

	public Cat() {
	}

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
