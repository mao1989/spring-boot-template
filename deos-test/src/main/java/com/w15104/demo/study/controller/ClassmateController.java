package com.w15104.demo.study.controller;


import com.w15104.demo.study.basic.config.Result;
import com.w15104.demo.study.basic.util.ResultUtil;
import com.w15104.demo.study.entity.Classmate;
import com.w15104.demo.study.service.IClassmateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/*
 *
 * @Description 班级控制器
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Api(tags="class", description = "woshi")
@RestController
@RequestMapping("/v1/classmate")
public class ClassmateController {

    /**
     * 获取班级服务类
     */
    @Resource
    private IClassmateService classmateService;

    /**
     * 根据班級ID查找班級信息  http://localhost:8181/wfh/classmate/get/1
     * @param id 班級ID
     * @return List<Classmate> 班級信息列表
     */
    @ApiOperation(value = "根据班级ID获得信息列表", httpMethod = "GET", code = 200)
    @ApiImplicitParam(name = "id", value = "班级ID", required = true, dataType = "String", paramType = "path")
    @ApiResponse(code = 401, message = "未认证", response = Result.class)
    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Result<List<Classmate>> findClassByID(@PathVariable String id) {
        //返回访问值
        return ResultUtil.ok(classmateService.findClassByID(id));
    }

}
