package com.zzm.student.dao;

import com.zzm.student.vo.StudentVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentDao {

    @Insert("insert into t_student(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Integer add(StudentVo studentVo);

    @Select("select create_time,update_time from t_student;")
    List<StudentVo> findAll();

}
