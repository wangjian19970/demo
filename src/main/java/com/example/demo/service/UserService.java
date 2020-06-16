package com.example.demo.service;


import com.example.demo.dto.User;
import com.example.demo.dto.UserExample;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.MD5Utils;
import com.example.demo.vo.UserVo;
import com.google.common.collect.Lists;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;


@Service
public class UserService {
    public long getUserTotalCount;
    @Autowired
    private UserMapper userMapper;

    public boolean insterUser(UserVo userVo) throws Exception {
        User user = new User();
        if (!ObjectUtils.isEmpty(userVo)) {
            userVo.setPassword(MD5Utils.getMD5Str(userVo.getPassword()));
            BeanUtils.copyProperties(userVo, user);
        }
        try {
            userMapper.insertSelective(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //登录
    public boolean toLogin(UserVo userVo) throws Exception {
        UserExample userExample = new UserExample();
        if (!ObjectUtils.isEmpty(userVo)) {
            userExample.createCriteria().andNameEqualTo(userVo.getName());
            List<User> usersList = userMapper.selectByExample(userExample);
            if (usersList.size() == 1 && MD5Utils.getMD5Str(userVo.getPassword()).equals(usersList.get(0).getPassword())) {
                return true;
            }
        }
        return false;
    }

    //查询出id在1-10之间的用户
    public List<UserVo> queryUser(int pageNo, int pagesize, Integer... id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(Arrays.asList(id));
        userExample.setLimit(pageNo);
        userExample.setOffset(pagesize);
        List<User> userDto = userMapper.selectByExample(userExample);
        List<UserVo> userVos = Lists.newArrayList();
        userDto.forEach(userDtos -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userDto, userVo);
            userVos.add(userVo);
        });
        return userVos;
    }

    private long getUserTototalCount() {
        long totalCount = userMapper.countByExample(null);
        return totalCount;
    }
}


