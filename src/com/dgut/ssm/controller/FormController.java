package com.dgut.ssm.controller;

import com.dgut.ssm.bean.BuyForm;
import com.dgut.ssm.bean.BuyLog;
import com.dgut.ssm.bean.SaleLog;
import com.dgut.ssm.bean.SalesForm;
import com.dgut.ssm.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/forms")
public class FormController {
    @Autowired
    private FormService formService;
    @GetMapping("/finish/{id}")

    /**
     * 点击按钮响应：设置状态为已发货，同时记录物流信息：物流信息表需要：当前时间，商品id，商品数量，发往地点
     * 什么时间，发出多少什么货物，发货单id是
     * 一个表对应一个售卖id，一一对应
     */
    public String finishForm(@PathVariable("id") Integer id)
    {
       formService.finishForm(id);
       //将当前日期存入数据库，此处Date是SQL的 date

        Date date=new Date(System.currentTimeMillis());
        SalesForm salesForm=formService.getSalesFormById(id);
        SaleLog saleLog=new SaleLog(salesForm.getFormId(),salesForm.getGoodsId(),date,salesForm.getQuantity());
        formService.InsertLog(saleLog);
        formService.finishForm(id);
        return "redirect:/forms/list";
    }
    @GetMapping("list")
    public String formList(Model model)
    {
        List<SalesForm> forms= formService.getAllRunningForm();
        List<SaleLog> logs=formService.getLogs();
        model.addAttribute("logs",logs);
        model.addAttribute("forms",forms);
        return "saleformList";
    }
    //    ---------------------进货管理-----------------------------
    @GetMapping("buyList")
    public String buyFormList(Model model)
    {
        List<BuyForm> forms= formService.getAllRunningBuyForm();
        List<BuyLog> logs=formService.getBuyLogs();
        System.out.println(forms);
        model.addAttribute("logs",logs);
        model.addAttribute("forms",forms);
        return "buyformList";
    }
    @GetMapping("/finishBuy/{id}")

    public String finishBuyForm(@PathVariable("id") Integer id)
    {
        formService.finshBuyForm(id);
        //将当前日期存入数据库，此处Date是SQL的 date
        //TODO 此处是传id过来再从数据库里取出form，消耗了一次查询，想直接把form对象传过来呢？
        Date date=new Date(System.currentTimeMillis());
        BuyForm buyForm=formService.getBuyFormById(id);
        BuyLog buyLog=new BuyLog(buyForm.getFormId(),date,buyForm.getGoodsId(),buyForm.getQuantity());
        formService.InsertBuyLog(buyLog);
        return "redirect:/forms/buyList";
    }

}
