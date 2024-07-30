package com.mrj.ocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrj.ocms.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}