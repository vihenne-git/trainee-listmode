package com.boss.demo.mytask.service;

import com.alibaba.fastjson.JSONObject;
import com.boss.demo.mytask.entity.ApplyForm;
import com.boss.demo.mytask.entity.FormItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author asus
 * @create 9/7/2020 下午4:52
 */
@Service
public class CartService {
    @Autowired
    private HttpSession session;

    @Autowired
    private ApplyFormService applyFormService;

    private HashMap<Integer, FormItem> myCart;

    public boolean add(FormItem formItem){
        //System.out.println("add");
        getMyCart();
        myCart.put(formItem.getItemId(), formItem);
        return true;
    }
    public boolean remove(int ItemId){
        //System.out.println("remove");
        getMyCart();
        myCart.remove(ItemId);
        return true;
    }
    public boolean edit(FormItem formItem){
        //System.out.println("edit");
        getMyCart();
        myCart.remove(formItem.getItemId());
        myCart.put(formItem.getItemId(), formItem);
        return true;
    }
    public String list(){
        //System.out.println("list");
        getMyCart();
        return JSONObject.toJSONString(myCart.entrySet().toArray());
    }
    public String settle(ApplyForm applyForm){
        getMyCart();
        applyFormService.settle(applyForm);
        return "settle succeed";
    }
    public HashMap<Integer, FormItem> getMyCart(){
        myCart = (HashMap) session.getAttribute("myCart");
        if(myCart == null){
            myCart = new HashMap<Integer, FormItem>();
            session.setAttribute("myCart", myCart);
        }
        return myCart;
    }
}
