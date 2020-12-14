package com.dgut.ssm.controller;

import com.dgut.ssm.bean.Contact;
import com.dgut.ssm.service.ContactService;
import com.dgut.ssm.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService service;
    @Autowired
    private FormService formService;
    @GetMapping("/list")
    public String list(Model model) {
        List<Contact> contacts=service.getAllContact();
        model.addAttribute("contacts",contacts);
        /*List<Goods> goods = service.getAllGoods();
        model.addAttribute("goods", goods);
        return "goodList";*/
        return "contactList";
    }
    @GetMapping("/run/{id}")
    public String runForm(@PathVariable("id") Integer id){
        //TODO 优化，当刚好可以发货时可以先发货再进货，此处是小于和等于都先生成进货单;返回值可以改为减法的值，
        // 0就生成发货单后生成进货单，小于0则携带此数值去生产进货单，
        // 点击链接只会弹出一个窗口，同时做进货单和发货单响应有点麻烦
        if(formService.checkIfEnough(id))//存量>出货量时
        {
            formService.generateForm(id);
            //录入售卖日志是仓库管理员需要做的，不是销售管理员
            return "redirect:/contact/list";
        }
        else
            return "";
    }
}
