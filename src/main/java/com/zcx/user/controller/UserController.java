package com.zcx.user.controller;

import com.zcx.user.service.UserService;
import com.zcx.utils.ResultBuilder;
import com.zcx.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResultVo getUserById(@PathVariable Integer id) {
    String userName = userService.getUserById(id).getName();
    return ResultBuilder.buildSuccess().with("userName", userName);
  }

}
