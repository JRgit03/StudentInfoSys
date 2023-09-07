package com.company.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.pojo.Student;

public interface IStudentService extends IService<Student> {
	IPage<Student> getPage(long current, long size, Student student);
}
