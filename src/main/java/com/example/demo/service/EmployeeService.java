package com.example.demo.service;


import com.example.demo.dto.Employee;
import com.example.demo.dto.EmployeeExample;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.utils.ExcelUtil;
import com.example.demo.vo.EmployeeVo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    public List<EmployeeVo> queryEmployee(int pageNo, int pageSize, String name) {
        EmployeeExample employeeExample = new EmployeeExample();
        // employeeExample.createCriteria().andIdIn(Arrays.asList(id));
        employeeExample.setLimit(pageNo);
        employeeExample.setOffset(pageSize);
        employeeExample.createCriteria().andNameLike("%" + name + "%");
        List<Employee> employeeDtos = employeeMapper.selectByExample(employeeExample);
        List<EmployeeVo> employeeVos = Lists.newArrayList();
        employeeDtos.forEach(employeeDto -> {
            EmployeeVo employeeVo = new EmployeeVo();
            BeanUtils.copyProperties(employeeDto, employeeVo);
            employeeVos.add(employeeVo);
        });
        return employeeVos;
    }

    public long getEmployeeTotalCount(String name) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andNameLike("%" + name + "%");
        long totalCount = employeeMapper.countByExample(employeeExample);
        return totalCount;
    }

    public int delEmployee(Integer id) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdIn(Arrays.asList(id));
        int del = employeeMapper.deleteByExample(employeeExample);
        return del;
    }

    public EmployeeVo updEmployee(EmployeeVo employeeVo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeVo, employee);
        int flag = employeeMapper.updateByPrimaryKey(employee);
        if (flag == 1) {
            Employee employee1 = employeeMapper.selectByPrimaryKey(employeeVo.getId());
            BeanUtils.copyProperties(employee, employeeVo);
            return employeeVo;
        }
        return null;
    }

    public int addEmployee(EmployeeVo employeeVo) {
        Employee employee = new Employee();
        if (!ObjectUtils.isEmpty(employee)) {
            BeanUtils.copyProperties(employeeVo, employee);
        }
        return employeeMapper.insertSelective(employee);
    }

    //导出
    public void writeExcel(HttpServletResponse response) {
        EmployeeExample employeeExample = new EmployeeExample();
        List<Integer> values = Lists.newArrayList();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        employeeExample.createCriteria().andIdIn(values);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        ExcelUtil.writeExcel(response, employeeList, "test", "test", Employee.class);
    }

    //导入
    public void readExcel(MultipartFile multipartFile) throws Exception {
        Employee employee = new Employee();
        List<Object> objects = ExcelUtil.readExcel(multipartFile, employee, 1, 1);
        for (int i = 0; i < objects.size(); i++) {
            BeanUtils.copyProperties(objects.get(i), employee);
            employeeMapper.insertSelective(employee);
        }
    }
}