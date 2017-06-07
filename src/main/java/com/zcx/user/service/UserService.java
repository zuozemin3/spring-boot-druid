package com.zcx.user.service;

import com.zcx.user.vo.UserVo;

public interface UserService {

  /**
   * 根据用户id获取用户
   */
  UserVo getUserById(Integer id);
}
