package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Child;
import com.example.demo.service.ChildService;

@RestController
public class Controller {
@Autowired
private ChildService cService;
@PostMapping("/add")
public String postStudent(@RequestBody Child ch)
{
	return cService.addStudent(ch);
}

@GetMapping("/show")
public List<Child> showStudent()
{
	List<Child> alist= new ArrayList<>();
	alist=cService.getChild();
	return alist;
}

@GetMapping("/{field}")
public List<String> showFields(@PathVariable String field){
	return cService.getField(field);
	
}

@GetMapping("/{offset}/{pagesize}")
public List<Child> view(@PathVariable int offset, @PathVariable int pagesize){
	return cService.view(offset, pagesize);
}

@GetMapping("/{offset}/{pagesize}/{field}")
public List<String> viewPageField(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
	return cService.viewFieldPage(offset, pagesize, field);
}

}
