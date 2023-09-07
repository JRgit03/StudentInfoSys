package com.company;

import cn.hutool.core.util.RandomUtil;
import com.company.mapper.ScoreMapper;
import com.company.pojo.Course;
import com.company.pojo.Score;
import com.company.pojo.Student;
import com.company.service.ICourseService;
import com.company.service.IScoreService;
import com.company.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class StudentInfoSysApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	private ICourseService courseService;

	@Autowired
	private IStudentService studentService;

	@Autowired
	private IScoreService scoreService;

	@Test
	void insertScore(){
		List<Score> scoreList = new ArrayList<>();
		List<Course> courseList = courseService.list();
		List<Student> studentList = studentService.list();
		for (Course course : courseList) {
			for (Student student : studentList) {
				Score score = new Score();
				score.setSno(student.getSno());
				score.setCno(course.getCno());
				score.setGrade(RandomUtil.randomInt(50, 101));
				scoreList.add(score);
			}
		}
		scoreService.saveBatch(scoreList);
	}

	@Test
	void query(){
		System.out.println(studentService.getById("2021003171"));
	}
}
