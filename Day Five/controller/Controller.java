package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		stuService.deleteStudent(id);
	}
	@PutMapping("update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student stu) {
		return stuService.updateStudent(id, stu);
	}
  
  
}