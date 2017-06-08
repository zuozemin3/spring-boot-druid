package com.zzm.user.service;

import com.zzm.user.vo.UserVo;

public interface UserService {

  /**
   * 根据用户id获取用户
   */
  UserVo getUserById(Integer id);
}
