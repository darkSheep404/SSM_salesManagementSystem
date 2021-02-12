package com.dgut.ssm.dao;

import com.dgut.ssm.bean.Contact;
import com.dgut.ssm.bean.ContactSearchCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface ContactDao {
    public Contact getContactById(Integer id);
    public Contact getContactByIdWithPerson(Integer id);//带销售人员与客户的查询
    public Contact getContactByIdWithForm(Integer id);//带采购单的查询
    public Contact getContactByIdWithAll(Integer id);//携带所有信息的查询
    public List<Contact> getAllContact();//查询全部合同列表
    public void reduceUnfinishedNum(Integer id);//减少合同里的未发货数量
    public Integer insertContactWithPerson(@Param("customId") Integer customId, @Param("salesmanId")Integer salesmanId,@Param("contact") Contact contact);
    public void delContactById(Integer id);
    public void deliveryFormAdd(Integer id);
    public void updateContactWithPerson(@Param("customId") Integer customId, @Param("salesmanId")Integer salesmanId,@Param("contactId") Integer contactId);
    public List<Contact> searchContactByCondition(ContactSearchCondition contactSearchCondition);
}
