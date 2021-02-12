package com.dgut.ssm.controller;

import com.dgut.ssm.bean.Salesman;
import com.dgut.ssm.bean.SalesmanSearchCondition;
import com.dgut.ssm.bean.Salesman;
import com.dgut.ssm.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/salesman")
public class SalesmanController {
    @Autowired
    private SalesmanService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Salesman> salesman = service.getAllSalesman();
        model.addAttribute("salesman", salesman);
        return "salesmanList";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Salesman salesman = service.getSalesmanById(id);
        model.addAttribute("salesman", salesman);
        return "salesmanEdit";
    }

    @PutMapping("/update")
    public String update(Salesman salesman) {
        service.updateSalesman(salesman);
        return "redirect:/salesman/list";
    }
    @ModelAttribute
    public void prepareModel(@RequestParam(value = "salesmanId", required = false) Integer id, HttpServletRequest request, Model model) {
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        if (servletPath.equals("/salesman/update")) {
            Salesman salesman = service.getSalesmanById(id);
            //用id获取更改前数据库中的数据
            model.addAttribute("salesman", salesman);
        }
    }
    @GetMapping("salesmanAdd")
    public String salesmanAdd() {
        return "salesmanAdd";
    }

    @PostMapping("add")
    public String add(Salesman salesman) {
        service.AddSalesman(salesman);
        return "redirect:/salesman/list";
    }
    @GetMapping("search")
    public String search(SalesmanSearchCondition salesmanSearchCondition, Model model)
    {
        List<Salesman> salesman= service.searchSalesmanByCondition(salesmanSearchCondition);
        model.addAttribute("salesman", salesman);
        return "salesmanList";
    }
}
