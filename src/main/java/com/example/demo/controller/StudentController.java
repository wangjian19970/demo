package com.example.demo.controller;


import com.example.demo.dto.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.ReturnResult;
import com.example.demo.utils.ReturnResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/query")
   public ReturnResult<Student> queryStudents(@RequestParam Integer...id){
        return ReturnResultUtils.returnSuccess(studentService.queryStudents());
    }
}
