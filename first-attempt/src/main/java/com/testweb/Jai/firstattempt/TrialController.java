package com.testweb.Jai.firstattempt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialController {

	@Autowired
	private ReturnList retrunList;
	
	
	@RequestMapping(value="/hello", method= RequestMethod.GET)
	public String HelloFun(){
		return "Hi!";
	}
	
	@RequestMapping(value="/hello/{s}", method= RequestMethod.GET)
	public String retrunPathVar(@PathVariable String s) {
		return s;
	}
	
	@RequestMapping(value="/hellos", method= RequestMethod.GET)
	public String returnReqparam(@RequestParam(value="name", required=false) String s) {
		return s;
	}
	
	@RequestMapping(value="/hello/list", method= RequestMethod.GET)
	public List<Person> returnls() {
		return retrunList.getAllNames();
	}
}
