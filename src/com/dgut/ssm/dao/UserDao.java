package com.dgut.ssm.dao;

import com.dgut.ssm.bean.User;
import com.dgut.ssm.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByName(String userName);
    public List<User> getAllUser();
    public void delUser(Integer id);
    //根据字段名写，不能通用
    public void InsertUser(User user);
    public void updateUser(User user);
}
