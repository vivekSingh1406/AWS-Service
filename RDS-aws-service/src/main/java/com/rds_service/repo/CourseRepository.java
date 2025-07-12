package com.rds_service.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rds_service.binding.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable> {

}
