package com.company.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class ScoreVO {
	private String sno;
	private String cno;
	private Integer grade;
	private String sname;
	private String cname;
	private Integer credit;
}
