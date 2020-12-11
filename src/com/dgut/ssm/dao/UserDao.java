package com.dgut.ssm.dao;

import com.dgut.ssm.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
public User getUserByName(String userName);
}
