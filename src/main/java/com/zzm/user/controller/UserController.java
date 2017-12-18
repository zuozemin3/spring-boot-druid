package com.zzm.user.controller;

import com.zzm.user.service.UserService;
import com.zzm.user.vo.UserVo;
import com.zzm.utils.ResultBuilder;
import com.zzm.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kris
 */
@Slf4j
@Api(description = "用户相关接口")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "path",dataType = "int")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultVo getUserById(@PathVariable Integer id) {
        UserVo userVo = userService.getUserById(id);
        return ResultBuilder.buildSuccess().with("userName", userVo.getName());
    }

    @ApiOperation(value = "创建用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultVo saveUser(@RequestBody UserVo userVo) {
        Integer id = userService.add(userVo);
        return ResultBuilder.buildSuccess().with("id", id);
    }
}
