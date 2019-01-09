package com.testweb.Jai.firstattempt;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ReturnList {

public List<Person> getAllNames();	
	
}

@Service
class ReturnListService implements ReturnList{
	
	List<Person> ls = new ArrayList<>();
	List<String> interest = new ArrayList<>();
	
	public List<Person> getAllNames(){
		ls.clear();
		interest.clear();
		interest.add("football");interest.add("basketball");interest.add("cricket");interest.add("table-tennis");
		ls.add(new Person("Joseph",'M',24,interest));
		ls.add(new Person("Meera",'F',23,interest));
		ls.add(new Person("Mannu",'M',21,interest));
		return ls;
		}
}


