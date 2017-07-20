package com.zzm.user.service;

import com.zzm.user.vo.UserVo;

public interface UserService {

    /**
     * 根据用户id获取用户信息
     */
    UserVo getUserById(Integer id);

    /**
     * 新增用户
     */
    Integer add(UserVo userVo);
}
