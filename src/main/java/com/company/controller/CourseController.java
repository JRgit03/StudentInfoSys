package com.company.controller;

import com.company.pojo.Course;
import com.company.service.ICourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Resource
	private ICourseService courseService;

	@GetMapping
	public List<Course> getAllCourse(){
		return courseService.list();
	}

}
