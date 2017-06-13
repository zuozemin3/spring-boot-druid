package com.zzm.student.dao;

import com.zzm.student.vo.StudentVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface StudentDao {

  @Insert("insert into t_student(name) values(#{name})")
  @Options(useGeneratedKeys = true, keyColumn = "id")
  Integer add(StudentVo studentVo);

}
