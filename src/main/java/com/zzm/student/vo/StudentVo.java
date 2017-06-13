package com.zzm.student.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class StudentVo implements Serializable {

  private Integer id;
  private String name;
  private Date createTime;
  private Date updateTime;
}
