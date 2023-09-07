package com.company.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.mapper.StudentMapper;
import com.company.pojo.Student;
import com.company.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements IStudentService {

	@Override
	public IPage<Student> getPage(long current,long size,Student student) {
		IPage<Student> iPage = new Page<>(current,size);
		QueryChainWrapper<Student> queryChainWrapper = query();
		queryChainWrapper
				.eq(student.getSno() != null && !("".equals(student.getSno())), "sno", student.getSno())
				.like(student.getSname() != null && !("".equals(student.getSname())), "sname", student.getSname())
				.eq(student.getSpeciality() != null && !("".equals(student.getSpeciality())), "speciality", student.getSpeciality())
				.eq(student.getSclass() != null && !("".equals(student.getSclass())), "sclass", student.getSclass());
		return queryChainWrapper.page(iPage);
	}
}
