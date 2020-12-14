package com.dgut.ssm.dao;

import com.dgut.ssm.service.FormService;
import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class ContactDaoTest {
    private SqlSession session;
    private ConfigurableApplicationContext context;
    @Test
    void getContactById() {
        /*GoodsDao dao=session.getMapper(GoodsDao.class);
        Goods goods=dao.getGoodsById(101);*/
        ContactDao dao=session.getMapper(ContactDao.class);
        //System.out.println(dao.getContactById(101));
        //System.out.println(dao.getContactByIdWithPerson(101));
        System.out.println(dao.getAllContact());
    }


    @BeforeEach
    public void init()
    {
        context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory sqlSessionFactory=context.getBean("sqlSessionFactory",SqlSessionFactory.class);
        session=sqlSessionFactory.openSession();
    }
    @AfterEach
    public void  close()
    {
        session.close();
    }
}