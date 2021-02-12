package com.dgut.ssm.controller;

import com.dgut.ssm.bean.CustomGroup;
import com.dgut.ssm.bean.Goods;
import com.dgut.ssm.bean.SalesmanGroup;
import com.dgut.ssm.service.GroupByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/groupBy")
public class GroupByController {
    @Autowired
    private GroupByService service;

    @GetMapping("/goods")
    public String groupByGoods(Model model)
    {
       List<Goods> goods= service.groupByGoods();
       model.addAttribute("goods",goods);
       return "groupByList";
    }
    @GetMapping("/custom")
    public String groupByCustom(Model model)
    {
        List<CustomGroup> custom= service.groupByCustom();
        model.addAttribute("custom",custom);
        return "groupByCustom";
    }
    @GetMapping("/salesman")
    public String groupBySalesman(Model model)
    {
        List<SalesmanGroup> salesman= service.groupBySalesman();
        model.addAttribute("salesman",salesman);
        return "groupBySalesman";
    }
}
