package com.boss.demo.mytask.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.boss.demo.mytask.entity.po.ApplyForm;
import com.boss.demo.mytask.entity.po.FormItem;
import com.boss.demo.mytask.service.ApplyFormService;
import com.boss.demo.mytask.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author asus
 * @create 14/7/2020 上午11:29
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private HttpSession session;

    @Autowired
    private ApplyFormService applyFormService;

    private HashMap<Integer, FormItem> myCart;


    @Override
    public boolean add(FormItem formItem){
        getMyCart();
        myCart.put(formItem.getItemId(), formItem);
        return true;
    }

    @Override
    public boolean remove(int itemId){
        getMyCart();
        myCart.remove(itemId);
        return true;
    }

    @Override
    public boolean edit(FormItem formItem){
        getMyCart();
        myCart.remove(formItem.getItemId());
        myCart.put(formItem.getItemId(), formItem);
        return true;
    }

    @Override
    public String list(){
        getMyCart();
        return JSONObject.toJSONString(myCart.entrySet().toArray());
    }

    @Override
    public String settle(ApplyForm applyForm){
        getMyCart();
        applyFormService.settle(applyForm);
        return "settle succeed";
    }

    /**
     *
     *
     * @description:用于获取购物车对象
     * @return: {HashMap<Integer, FormItem>}
     * @author: YuHangChen
     * @time: 14/7/2020 下午2:51
     */
    @Override
    public HashMap<Integer, FormItem> getMyCart(){
        myCart = (HashMap) session.getAttribute("myCart");
        if(myCart == null){
            myCart = new HashMap<Integer, FormItem>();
            session.setAttribute("myCart", myCart);
        }
        return myCart;
    }
}
