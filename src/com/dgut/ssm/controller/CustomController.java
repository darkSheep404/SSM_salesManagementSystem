package com.dgut.ssm.controller;

import com.dgut.ssm.bean.Custom;
import com.dgut.ssm.bean.Custom;
import com.dgut.ssm.bean.CustomSearchCondition;
import com.dgut.ssm.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    private CustomService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Custom> custom = service.getAllCustom();
        model.addAttribute("custom", custom);
        return "customList";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Custom custom = service.getCustomById(id);
        model.addAttribute("custom", custom);
        return "customEdit";
    }

    @PutMapping("/update")
    public String update(Custom custom) {
        service.updateCustom(custom);
        return "redirect:/custom/list";
    }
    @ModelAttribute
    public void prepareModel(@RequestParam(value = "customId", required = false) Integer id, HttpServletRequest request, Model model) {
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        if (servletPath.equals("/custom/update")) {
            Custom custom = service.getCustomById(id);
            //用id获取更改前数据库中的数据
            model.addAttribute("custom", custom);
        }
    }
    @GetMapping("customAdd")
    public String customAdd() {
        return "customAdd";
    }
    @PostMapping("add")
    public String add(Custom custom) {
        service.AddCustom(custom);
        return "redirect:/custom/list";
    }
    @GetMapping("search")
    public String search(CustomSearchCondition customSearchCondition, Model model)
    {
        List<Custom> custom= service.searchCustomByCondition(customSearchCondition);
        model.addAttribute("custom", custom);
        return "customList";
    }
}
