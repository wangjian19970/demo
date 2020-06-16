package com.example.demo.service;

import com.example.demo.dto.Student;
import com.example.demo.dto.StudentExample;

import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student queryStudents(Integer... id) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIdIn(Arrays.asList(id));
        //time
        //创建一个user表，字段有id name password create_time update_time
        //1注册一个用户 name作为账号 就是手机号 password使用md5加密保存
        //2登录，判断不存在用户123456加密与password字段比较eq re succss
        //根据id查找学生
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        return studentList.get(0);
    }
}
