package com.zzm.user.dao;

import com.zzm.user.vo.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from t_user where id=#{id}")
    UserVo getUserById(@Param("id") Integer id);

    @Insert("insert into t_user(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true)
    Integer add(UserVo userVo);

    @Select("select create_time,update_time from t_user;")
    List<UserVo> findAll();
}
