package com.dgut.ssm.service;

import com.dgut.ssm.bean.Contact;
import com.dgut.ssm.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDao dao;
    public List<Contact> getAllContact(){
        List<Contact> contacts= dao.getAllContact();
        System.out.println(contacts);
        return contacts;
    }
}
