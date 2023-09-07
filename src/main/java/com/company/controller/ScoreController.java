package com.company.controller;

import cn.hutool.core.bean.BeanUtil;
import com.company.pojo.Score;
import com.company.pojo.ScoreVO;
import com.company.pojo.Student;
import com.company.service.ICourseService;
import com.company.service.IScoreService;
import com.company.service.IStudentService;
import javafx.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/score")
public class ScoreController {
	@Resource
	private IScoreService scoreService;

	@Resource
	private IStudentService studentService;

	@Resource
	private ICourseService courseService;

	@GetMapping
	public List<ScoreVO> getAllScore(){
		List<Score> scoreList = scoreService.list();
		Map<String,String> studentHash = new HashMap<>();
		studentService.list().forEach(student -> {
			String sno = student.getSno();
			String sname = student.getSname();
			studentHash.put(sno,sname);
		});
		Map<String, Pair<String,Integer>> courseHash = new HashMap<>();
		courseService.list().forEach(course -> {
			String cno = course.getCno();
			String cname = course.getCname();
			Integer credit = course.getCredit();
			courseHash.put(cno,new Pair<>(cname,credit));
		});
		return scoreList.stream().map(score -> {
			ScoreVO scoreVO = new ScoreVO();
			BeanUtil.copyProperties(score, scoreVO, true);
			scoreVO.setSname(studentHash.get(scoreVO.getSno()));
			Pair<String, Integer> pair = courseHash.get(scoreVO.getCno());
			scoreVO.setCname(pair.getKey());
			scoreVO.setCredit(pair.getValue());
			return scoreVO;
		}).collect(Collectors.toList());
	}
}
