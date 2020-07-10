package com.boss.demo.mytask.service;

import com.boss.demo.mytask.dao.ApplyFormDAO;
import com.boss.demo.mytask.dao.FormItemDAO;
import com.boss.demo.mytask.entity.ApplyForm;
import com.boss.demo.mytask.entity.FormItem;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author asus
 * @create 9/7/2020 下午4:51
 */
@Service
public class ApplyFormService {
    @Autowired
    private CartService cartService;

    @Autowired
    private ApplyFormDAO applyFormDAO;

    @Autowired
    private FormItemDAO formItemDAO;
    public void settle(ApplyForm applyForm){
        FormItem formItem ;
        applyFormDAO.insert(applyForm);
        HashMap<Integer, FormItem> cart = cartService.getMyCart();
        Iterator cartIt = cart.keySet().iterator();
        while (cartIt.hasNext()) {
            Object key = cartIt.next();
            FormItem value = cart.get(key);
            value.setFormId(applyForm.getFormId());
            formItemDAO.insert(value);
        }
    }
    public String listById (int form_id){
        return applyFormDAO.selectById(form_id).toString();
    }


}
