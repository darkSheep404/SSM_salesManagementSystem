package com.dgut.ssm.dao;

import com.dgut.ssm.bean.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactDao {
    public Contact getContactById(Integer id);
    public Contact getContactByIdWithPerson(Integer id);//带销售人员与客户的查询
    public Contact getContactByIdWithForm(Integer id);//带采购单的查询
    public Contact getContactByIdWithAll(Integer id);//携带所有信息的查询
    public List<Contact> getAllContact();//查询全部合同列表

}
