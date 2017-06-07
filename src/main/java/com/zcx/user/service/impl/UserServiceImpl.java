package com.zcx.user.service.impl;

import com.zcx.user.dao.UserDao;
import com.zcx.user.service.UserService;
import com.zcx.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public UserVo getUserById(Integer id) {
    if (id == null || id.intValue() <= 0) {
      throw new IllegalArgumentException("id is invalid");
    }
    return userDao.getUserById(id);
  }
}
