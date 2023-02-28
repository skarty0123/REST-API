package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {

	@Autowired
	private ChildRepo repo;
	
	//POST
	public String addStudent(Child obj) {
	    repo.save(obj);
	    return "true";
	}
	
	//GET all details
	public List<Child> getChild(){
		List<Child> arr=new ArrayList<>();
		arr=repo.findAll();
		return arr;
	}
	
	//GET the particular column


	    public List<String> getField(String field) {
	        List<String> ans = new ArrayList<>();

	        switch (field) {
	            case "babyFirstName":
	                for (Child child : repo.findAll()) {
	                    ans.add(child.getBabyFirstName());
	                }
	                break;
	            case "babyLastName":
	                for (Child child : repo.findAll()) {
	                    ans.add(child.getBabyLastName());
	                }
	                break;
	            case "fatherName":
	                for (Child child : repo.findAll()) {
	                    ans.add(child.getFatherName());
	                }
	                break;
	            case "motherName":
	                for (Child child : repo.findAll()) {
	                    ans.add(child.getMotherName());
	                }
	                break;
	            case "address":
	                for (Child child : repo.findAll()) {
	                    ans.add(child.getAddress());
	                }
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid field name: " + field);
	        }

	        return ans;
	    }
	    
	   //pagination
		public List<Child> view(int pageno, int pagesize){
			//Pageable p=PageRequest.of(PageNo, PageSize);
			Pageable p=PageRequest.of(pageno, pagesize);
			Page<Child> c=repo.findAll(p);
			return c.toList();
		}
		
		//pagination with field names
		public List<String> viewFieldPage(int pageno, int pagesize, String field){
			//Pageable p=PageRequest.of(PageNo, PageSize);
			Pageable p=PageRequest.of(pageno, pagesize);
			Page<Child> c=repo.findAll(p);
			List<Child> arr=c.getContent();
	        List<String> ans = new ArrayList<>();

			switch (field) {
            case "babyFirstName":
                for (Child child : arr) {
                    ans.add(child.getBabyFirstName());
                }
                break;
            case "babyLastName":
                for (Child child : arr) {
                    ans.add(child.getBabyLastName());
                }
                break;
            case "fatherName":
                for (Child child : arr) {
                    ans.add(child.getFatherName());
                }
                break;
            case "motherName":
                for (Child child : arr) {
                    ans.add(child.getMotherName());
                }
                break;
            case "address":
                for (Child child : arr) {
                    ans.add(child.getAddress());
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + field);
        }

        return ans;
		}
}

	

