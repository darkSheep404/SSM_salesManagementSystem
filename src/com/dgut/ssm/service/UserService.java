package com.dgut.ssm.service;

import com.dgut.ssm.bean.User;
import com.dgut.ssm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao dao;
    public User getUserByName(String userName)
    {
        User user= dao.getUserByName(userName);
        return user;
    }
    public String CheckUserByName(String userName,String userPw)
    {
        User user= dao.getUserByName(userName);
        if (user==null|| !userPw.equals(user.getUserPw()) )
            return "fail";
        else return user.getUserType();
    }
}
