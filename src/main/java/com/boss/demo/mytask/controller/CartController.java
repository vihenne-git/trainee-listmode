package com.boss.demo.mytask.controller;

import com.boss.demo.mytask.entity.ApplyForm;
import com.boss.demo.mytask.entity.FormItem;
import com.boss.demo.mytask.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author asus
 * @create 9/7/2020 下午4:49
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/add")
    public String add(@RequestBody FormItem formItem){
        cartService.add(formItem);
        return "add item :"+formItem.getName();
    }
    @RequestMapping("/remove")
    public String remove(@RequestBody FormItem formItem){
        cartService.remove(formItem.getItemId());
        return null;
    }
    @RequestMapping("/edit")
    public String edit(@RequestBody FormItem formItem){
        cartService.edit(formItem);
        return null;
    }
    @RequestMapping("/list")
    public String list(@RequestBody FormItem formItem){
        return cartService.list();
    }
    @RequestMapping("/settle")
    public String settle(@RequestBody ApplyForm applyForm){
        return cartService.settle(applyForm);
    }
}
