package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class TestController3 {

	@RequestMapping(value="/myFav/{myFav}",method=RequestMethod.GET)
	public String getMyFav(@PathVariable String myFav)
	{
		return "My favorite color is "+myFav;
		
	}
}