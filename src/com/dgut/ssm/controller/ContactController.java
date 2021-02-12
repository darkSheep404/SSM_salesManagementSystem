package com.dgut.ssm.controller;

import com.dgut.ssm.bean.*;
import com.dgut.ssm.service.ContactService;
import com.dgut.ssm.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<SalesForm> salesForms=formService.getAllFormBeforeRun();
        model.addAttribute("contacts",contacts);
        model.addAttribute("salesForms",salesForms);

        return "contactList";
    }
    @GetMapping("/run/{id}/{contactId}")
    public String runForm(@PathVariable("id") Integer id,@PathVariable("contactId") Integer contactId,Model model){

        // 大于0生成进货单，否则则携带此数值去生产进货单，
        //生成发货单操作：更改表单发货状态为true,减去商品库存,合同未发货数量+1--更改到录入合同时
        int res=formService.checkIfEnough(id);
        /*库存量减去本次合同量*/
        if(res>0)//存量>出货量时
        {
            //表单id
            formService.generateForm(id);
            //增加未发货的发货单数量
            String detailPath="redirect:/contact/detail/"+contactId;
            //录入售卖日志是仓库管理员需要做的，不是销售管理员
            return detailPath;
        }
        else
        {
            res=0-res;
            int goodsId=formService.getGoodsId(id);
            /*获取商品id，和差值，去进货*/
            model.addAttribute("res",res);
            model.addAttribute("goodsId",goodsId);
            return "buygoods";
        }

    }
    @GetMapping("/add")
    public String addContact(Model model)
    {
        List<Custom> customs=service.getAllCustom();
        List<Salesman> salesmans= service.getAllSalesman();
        List<Goods> goods= formService.getAllGoods();
        model.addAttribute("customs",customs);
        model.addAttribute("salemans",salesmans);
        model.addAttribute("goods",goods);
        /*下拉框选择客户，销售员，商品id与名称，合同id，采购数量*/
        //查询所有的客户与销售员，商品id与名称，手动输入合同id？合同id插入自增，手动输入采购数量
        return "contactAdd";
    }
    @PostMapping("/Insert")
    public String insert(@RequestParam(value = "customId")Integer customId,@RequestParam(value = "salesmanId") Integer salesmanId,Model model)
    {
        //根据id获取封装为对象存入
        //插入id自增并返回
        Integer id=service.insertContactWithPerson(customId,salesmanId);
        String detailPath="redirect:/contact/detail/"+id;
        return detailPath;
    }

    /**
     * 根据id显示当前合同的所有采购单，可以新增采购单，携带参数判断是否新增，是的话则客户和售货员不可编辑
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id,Model model){
        /*TODO 由根据合同id查改为根据合同查，取出合同内所有采购单对象*/
        String detailPath="redirect:/contact/detail/"+id;
        Contact contact=service.getContactWithAllById(id);
        model.addAttribute("contact",contact);
        return "contactdetail";
    }
    @GetMapping("del/{id}")
    public String del(@PathVariable("id") Integer id)
    {
        service.delContactById(id);
        return "redirect:/contact/list";
    }
    @GetMapping("/formAdd/{id}")
    public String add(Model model,@PathVariable("id") Integer id)
    {
        List<Goods> goods=service.getAllGoods();
        model.addAttribute("goods",goods);
        model.addAttribute("id",id);
        return "contactformAdd";
    }

    @PostMapping("/formInsert")
    public String insert(Integer id,Integer goodsId,Integer quantity)
    {
        String detailPath="redirect:/contact/detail/"+id;
        service.insertForm(id,goodsId,quantity);
        return "redirect:/contact/detail/"+id;
    }
    @PostMapping("/buy")
    public String buy(Integer goodsId,Integer num)
    {
        //TODO 生成进货单函数，并不是进货函数
        service.insertBuyForm(goodsId, num);
        return "redirect:/contact/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Contact contact = service.getContactWithPersonById(id);
        List<Custom> customs=service.getAllCustom();
        List<Salesman> salesmans= service.getAllSalesman();
        model.addAttribute("customs",customs);
        model.addAttribute("salemans",salesmans);
        model.addAttribute("contact",contact);
        return "contactEdit";
    }

    @PostMapping("/update")
    public String update(Integer customId, Integer salesmanId,Integer contactId) {
        service.updateContactWithPerson(customId, salesmanId, contactId);
        return "redirect:/contact/list";
    }
    @GetMapping("search")
    public String search(ContactSearchCondition contactSearchCondition, Model model)
    {
        List<Contact> contact= service.searchContactByCondition(contactSearchCondition);
        model.addAttribute("contact", contact);
        return "contactList";
    }
}
