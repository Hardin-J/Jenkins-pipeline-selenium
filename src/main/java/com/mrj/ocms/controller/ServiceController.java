package com.mrj.ocms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ocms.model.Course;
import com.mrj.ocms.service_impl.CourseServImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/course")
public class ServiceController {
	
	@Autowired
	CourseServImpl service;
	
	@PostMapping
	public String doAddNewCourse(@RequestBody Course cs) {
		String msg = "";
		try {
			msg = service.addCourse(cs);
		} catch (Exception e) {
			msg = "Transaction insert failed";
		}
		return msg;
	}
	
	@PutMapping
	public String doUpdateUser(@RequestBody Course cs) {
		String msg = "";
		try {
			msg = service.updateCourse(cs);
		} catch (Exception e) {
			msg = "Transaction update failed";
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public Course doFindCourseById(@PathVariable("id") int id) {
		Course cs;
		cs = service.getCourseById(id);
		if(cs != null) {
			return cs;			
		} else {
			return null;
		}
	}

	@DeleteMapping("{id}")
	public String doDeleteCourseById(@PathVariable("id") int id) {
		String msg = "";
		try {
			msg = service.deleteCourse(id);
		} catch (Exception e) {
			msg = "Transaction Delete Failed";
		}
		return msg;
	}
	
	@GetMapping("/allCourses")
	public List<Course> doFindAllCourses(){
		return service.listAllCourses();
	}
}
