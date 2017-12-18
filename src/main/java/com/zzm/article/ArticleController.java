package com.zzm.article;

import com.zzm.utils.ResultBuilder;
import com.zzm.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kris
 * @Description:
 * @date 2017年12月18日 11:46
 */

@Api(description = "文章操作相关接口")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @ApiOperation(value = "创建文章", notes = "")
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    ResultVo create(@ApiParam @RequestParam("params") String params) {

        return ResultBuilder.buildSuccess().with("userName", "");
    }
}


