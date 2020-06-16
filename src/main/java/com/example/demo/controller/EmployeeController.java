package com.example.demo.controller;


import com.example.demo.service.EmployeeService;
import com.example.demo.utils.PageUtils;
import com.example.demo.utils.ReturnResult;
import com.example.demo.utils.ReturnResultUtils;
import com.example.demo.vo.EmployeeVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Api(tags = "查询员工信息")
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("查询")
    @PostMapping(value = "/employees")
    public ReturnResult<EmployeeVo> getEmployees(@RequestParam int pageNo, @RequestParam String name) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentPage(pageNo);
        List<EmployeeVo> employeeVoList = employeeService.queryEmployee(pageUtils.getPageNo(), pageUtils.getPageSize(), name);
        pageUtils.setCurrentList(employeeVoList);
        pageUtils.setTotalCount(employeeService.getEmployeeTotalCount(name));
        return ReturnResultUtils.returnSuccess(pageUtils);
    }

    @ApiOperation("删除")
    @PostMapping("/del")
    public ReturnResult delEmployees(@ApiParam(value = "id", required = true) @RequestParam Integer id) {
        return ReturnResultUtils.returnSuccess(employeeService.delEmployee(id));
    }

    @ApiOperation("修改")
    @PostMapping("/upd")
    public ReturnResult updEmployee(@Validated EmployeeVo employeeVo) throws Throwable {
        return ReturnResultUtils.returnSuccess(employeeService.updEmployee(employeeVo));
    }

    @ApiOperation(value = "增加")
    @PostMapping(value = "/add")
    public ReturnResult addEmployee(@Validated EmployeeVo employeeVo) throws Throwable {
        return ReturnResultUtils.returnSuccess(employeeService.addEmployee(employeeVo));
    }
//覆盖率：你的每个Java类的测试覆盖率
    @ApiOperation("写入excel")
    @GetMapping(value = "/writeExcel")
    public ReturnResult writeExcel(HttpServletResponse response) throws IOException {
        employeeService.writeExcel(response);
        return ReturnResultUtils.returnSuccess();
    }


    @ApiOperation("导出excel")
    @PostMapping(value = "/readexcel")
    public ReturnResult writeJava(@RequestParam MultipartFile multipartFile) throws Exception {
        employeeService.readExcel(multipartFile);
        return ReturnResultUtils.returnSuccess();
    }

}