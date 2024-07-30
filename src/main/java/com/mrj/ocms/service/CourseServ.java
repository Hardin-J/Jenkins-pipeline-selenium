package com.mrj.ocms.service;

import java.util.List;
import com.mrj.ocms.model.Course;

public interface CourseServ {
	
	public String addCourse(Course cs);

	public List<Course> listAllCourses();

	public Course getCourseById(int id);

	public String updateCourse(Course cs);

	public String deleteCourse(int id);

}
