package com.dgut.ssm.controller;

import com.dgut.ssm.bean.Goods;
import com.dgut.ssm.bean.GoodsSearchCondition;
import com.dgut.ssm.service.GoodsService;
import com.dgut.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsConttoller {
    @Autowired
    private GoodsService service;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Goods> goods = service.getAllGoods();
        model.addAttribute("goods", goods);
        return "goodList";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Goods goods = service.getGoodsById(id);
        model.addAttribute("goods", goods);
        return "goodsEdit";
    }

    @PutMapping("/update")
    public String update(Goods goods) {
        service.updateGoods(goods);
        return "redirect:/goods/list";
    }

    @ModelAttribute
    public void prepareModel(@RequestParam(value = "goodsId", required = false) Integer id, HttpServletRequest request, Model model) {
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        if (servletPath.equals("/goods/update")) {
            Goods goods = service.getGoodsById(id);
            //用id获取更改前数据库中的数据
            model.addAttribute("goods", goods);
        }
    }

    @GetMapping("del/{id}")
    public String del(@PathVariable("id") Integer id) {
        service.delGoodsByid(id);

        //TODO model就是页面，要往页面存取东西才要加model
        return "redirect:/goods/list";
    }

    @GetMapping("goodsAdd")
    public String goodsAdd() {
        return "goodsAdd";
    }

    @PostMapping("add")
    public String add(Goods goods) {
        service.AddGoods(goods);
        return "redirect:/goods/list";
    }

    @PostMapping("login")
    public String loginCheck(String userName, String passWord) {
        String res = userService.CheckUserByName(userName, passWord);
        if (res.equals("fail"))
            return "loginFail";
        else if (res.equals("sales_admin"))
            /*如果是销售管理员*/
            return "redirect:/contact/list";

        else
            /*如果是仓库管理员*/
            return "redirect:/goods/list";
    }
    @GetMapping("search")
    public String search(GoodsSearchCondition goodsSearchCondition,Model model)
    {
       List<Goods> goods= service.searchGoodsByCondition(goodsSearchCondition);
        model.addAttribute("goods", goods);
        return "goodList";
    }
    //    ---------------------进货管理-----------------------------
    @GetMapping("disable/{id}")
    public String disable(@PathVariable("id") Integer id) {
        service.disable(id);
        return "redirect:/goods/list";
    }

}
