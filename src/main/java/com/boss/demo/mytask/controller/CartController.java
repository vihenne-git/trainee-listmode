package com.boss.demo.mytask.controller;

import com.boss.demo.mytask.utils.ReturnResult;
import com.boss.demo.mytask.entity.po.ApplyForm;
import com.boss.demo.mytask.entity.po.FormItem;
import com.boss.demo.mytask.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yuhangchen
 * @create 9/7/2020 下午4:49
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/add")
    public ReturnResult add(@RequestBody FormItem formItem) {
        cartService.add(formItem);
        return ReturnResult.success(200,"加入货品成功","add item :" + formItem.getName());
    }

    @RequestMapping("/remove")
    public ReturnResult remove(@RequestBody FormItem formItem) {
        cartService.remove(formItem.getItemId());
        return ReturnResult.success(200,"删除货品成功","remove item :" + formItem.getName());
    }

    @RequestMapping("/edit")
    public ReturnResult edit(@RequestBody FormItem formItem) {
        cartService.edit(formItem);
        return ReturnResult.success(200,"修改货品成功","edit item :" + formItem.getName());
    }

    @RequestMapping("/list")
    public ReturnResult list(@RequestBody FormItem formItem) {
        String data = cartService.list();
        if(data !=null){
            return ReturnResult.success(200,"查询购物车成功",data);
        }else {
            return ReturnResult.fail(404,"购物车为空","list :" + null);
        }
    }

    @RequestMapping("/settle")
    public ReturnResult settle(@RequestBody ApplyForm applyForm) {
        return ReturnResult.success(200,"申请成功",cartService.settle(applyForm));
    }
}
