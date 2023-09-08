package com.company.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.pojo.Student;
import com.company.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Resource
	private IStudentService studentService;

	@GetMapping
	public List<Student> studentList(){
		return studentService.list();
	}

	@PostMapping("/{current}/{size}")
	public IPage<Student> getAllStudent(@PathVariable long current, @PathVariable long size, @RequestBody Student student){
		System.out.println(student);
		return studentService.getPage(current,size,student);
	}

	@DeleteMapping("/{sno}")
	public boolean deleteStudentBySno(@PathVariable String sno){
		return studentService.removeById(sno);
	}

	@PostMapping
	public boolean saveStudent(@RequestBody Student student){
		System.out.println("新增：" + student);
		return studentService.save(student);
	}

	@PutMapping
	public boolean updateStudent(@RequestBody Student student){
		return studentService.updateById(student);
	}
}
