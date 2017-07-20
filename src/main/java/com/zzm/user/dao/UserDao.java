package com.zzm.user.dao;

import com.zzm.user.vo.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from t_user where id=#{id}")
    UserVo getUserById(@Param("id") Integer id);

    @Insert("insert into t_user(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true)
    Integer add(UserVo userVo);

}
