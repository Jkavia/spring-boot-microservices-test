package com.testweb.Jai.firstattempt;

import java.util.List;

public class Person {

	private String Name;
	private char Gender;
	private int Age;
	private List<String> interests;
	public Person(String name, char gender, int age, List<String> interests) {
		super();
		Name = name;
		Gender = gender;
		Age = age;
		this.interests = interests;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public List<String> getInterests() {
		return interests;
	}
	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	
}
