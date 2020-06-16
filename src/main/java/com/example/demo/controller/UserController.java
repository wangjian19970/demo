package com.example.demo.controller;

import com.example.demo.service.TaskService;
import com.example.demo.utils.PageUtils;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnResult;
import com.example.demo.utils.ReturnResultUtils;
import com.example.demo.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户")
@Log4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;


    @ApiOperation("注册")
    @PostMapping(value = "/toRegUser")
    public ReturnResult toRegUser(@Validated UserVo userVo) throws Exception {
        userService.insterUser(userVo);
        return ReturnResultUtils.returnSuccess();
    }

    @ApiOperation(value = "登录", notes = "data false代表登录失败")
    @PostMapping(value = "/toLogin")
    public ReturnResult<Boolean> toLogin(@Validated UserVo userVo) throws Exception {
        try {
            log.info("进入登录方法");
            boolean isLogin = userService.toLogin(userVo);
            log.info("完成登录方法");
            return ReturnResultUtils.returnSuccess(isLogin);
        } catch (Exception e) {
            log.debug(userVo.getName() + "登录出错了", e);
            log.error(userVo.getName() + "登录出错了", e);
            return ReturnResultUtils.returnFall(111, e.getMessage());
        }

    }

    @ApiOperation(value = "查询")
    @PostMapping(value = "/getUsers")
    public ReturnResult<UserVo> getUsers(@RequestParam int pageNo, @RequestParam Integer... id) {
        PageUtils pageUtils = new PageUtils();
        List<UserVo> userVoList = userService.queryUser(pageNo, pageUtils.getPageSize(), id);

        pageUtils.setCurrentList(userVoList);
        pageUtils.setCurrentPage(pageNo);
        pageUtils.setTotalCount(userService.getUserTotalCount);
        //pageUtils.se
        return ReturnResultUtils.returnSuccess(pageUtils);
    }

    @GetMapping(value = "/sendEmail")
    public ReturnResult sendEamil() throws InterruptedException {
        TaskService.getAddr();
        return ReturnResultUtils.returnSuccess();
    }
}




