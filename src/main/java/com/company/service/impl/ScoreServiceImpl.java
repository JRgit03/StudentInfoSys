package com.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.mapper.ScoreMapper;
import com.company.pojo.Score;
import com.company.service.IScoreService;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper,Score> implements IScoreService {

}
