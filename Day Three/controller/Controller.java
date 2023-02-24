package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@RestController
public class Controller
{ @Autowired
	private StudentService stuService;

	@PostMapping("/add")
	public Student postStudent(@RequestBody Student stu)
	{
		return stuService.addStudent(stu);
	}
	
	@GetMapping("/show")
	public List<Student> showStudent()
	{
		List<Student> alist= new ArrayList<>();
		alist=stuService.getStudent();
		return alist;
		
	}
  
  
}