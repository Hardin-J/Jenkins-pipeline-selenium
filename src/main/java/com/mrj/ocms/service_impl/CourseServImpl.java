package com.mrj.ocms.service_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.mrj.ocms.model.Course;
import com.mrj.ocms.repository.CourseRepo;
import com.mrj.ocms.service.CourseServ;

@Service
public class CourseServImpl implements CourseServ{

	CourseRepo repo;
	
	public CourseServImpl(CourseRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addCourse(Course cs) {
		repo.save(cs);
		return "Insert Success";
	}

	@Override
	public List<Course> listAllCourses() {
		return repo.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		Optional<Course> course = repo.findById(id);
		if(course.isPresent()) {
			return course.get();
		} else {
			return null;
		}
	}

	@Override
	public String updateCourse(Course cs) {
		repo.save(cs);
		return "Update Success";
	}

	@Override
	public String deleteCourse(int id) {
		repo.deleteById(id);
		return "Deletion Success";
	}

}
