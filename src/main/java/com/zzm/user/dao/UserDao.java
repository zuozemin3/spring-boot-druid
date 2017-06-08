package com.zzm.user.dao;

import com.zzm.user.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

  @Select("select id,name from t_user where id=#{id}")
  UserVo getUserById(@Param("id") Integer id);
}
