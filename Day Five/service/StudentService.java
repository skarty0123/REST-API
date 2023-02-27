package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.repoInterface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService 
{
	@Autowired
	private repoInterface repo1;
	
	public Student addStudent(Student obj)
	{
		return repo1.save(obj);
	}
	
	public List<Student> getStudent()
	{
		List<Student> arr= new ArrayList<>();
		arr=repo1.findAll();
		return arr;
	}
	public void deleteStudent(int id)
	{
		repo1.deleteById(id);
	}
	public Student updateStudent(int id, Student obj) {
		return repo1.saveAndFlush(obj);
	}
}