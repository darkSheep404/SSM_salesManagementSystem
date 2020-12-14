package com.dgut.ssm.dao;

import com.dgut.ssm.bean.Goods;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

class GoodsDaoTest {
    private SqlSession session;
    private ConfigurableApplicationContext context;


    @Test
    public void getGoodsById()
    {
        System.out.println(session);
        GoodsDao dao=session.getMapper(GoodsDao.class);
        Goods goods=dao.getGoodsById(101);
        System.out.println(goods);
    }

    @Test
    void testAll(){
        System.out.println(session);
        GoodsDao dao=session.getMapper(GoodsDao.class);
        List<Goods>  goods=dao.getAllGods();
        System.out.println(goods);
    }
    @Test
    void testUpdate()
    {
        System.out.println(session);
        System.out.println("中文Test");
        GoodsDao dao=session.getMapper(GoodsDao.class);
        Goods newgoods=new Goods(101,"dog",100.00,5,false);
        dao.update(newgoods);
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