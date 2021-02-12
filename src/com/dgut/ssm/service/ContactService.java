package com.dgut.ssm.service;

import com.dgut.ssm.bean.*;
import com.dgut.ssm.dao.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDao dao;
    @Autowired
    private SalesmanDao salesmanDao ;
    @Autowired
    private CustomDao customDao;
    @Autowired
    private FormDao formDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private BuyformDao buyformDao;
    public List<Contact> getAllContact(){
        List<Contact> contacts= dao.getAllContact();
        System.out.println(contacts);
        return contacts;
    }
    public void deliveryFormAdd(Integer id)
    {
        dao.deliveryFormAdd( id);
    }
    public List<Custom> getAllCustom()
    {
        return customDao.getAllCustom();
    }
    public List<Salesman> getAllSalesman()
    {
        return salesmanDao.getAllSalesman();
    }
    public Integer insertContactWithPerson(Integer customId, Integer salesmanId)
    {
        Contact contact=new Contact();
        dao.insertContactWithPerson(customId,salesmanId,contact);
        Integer id=contact.getContactId();
        return id;
    }
    public List<SalesForm> getSalesfromByContactId(Integer id)
    {
            return formDao.getFormListByContactId(id);
    }
    public void delContactById(Integer id)
    {
        dao.delContactById(id);
    }
    public void insertForm(Integer contactId,Integer goodsId,Integer quantity){
        formDao.insertForm(contactId,goodsId,quantity);
        dao.deliveryFormAdd(contactId);
    }
    public List<Goods> getAllGoods(){
        return  goodsDao.getAllGods();
    }
    public void insertBuyForm(Integer goodsId,Integer quantity)
    {
        buyformDao.insertBuyForm(goodsId,quantity);
    }

    public Contact getContactWithPersonById(Integer id) {
       return dao.getContactByIdWithPerson(id);
    }

    public void updateContactWithPerson( Integer customId, Integer salesmanId,Integer contactId) {
        dao.updateContactWithPerson(customId, salesmanId, contactId);
    }

    public Contact getContactWithAllById(Integer id) {
      return   dao.getContactByIdWithAll(id);
    }

    public List<Contact> searchContactByCondition(ContactSearchCondition contactSearchCondition) {
        return dao.searchContactByCondition(contactSearchCondition);
    }
}
