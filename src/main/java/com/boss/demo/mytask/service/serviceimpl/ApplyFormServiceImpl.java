package com.boss.demo.mytask.service.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.boss.demo.mytask.dao.ApplyFormDAO;
import com.boss.demo.mytask.dao.FormItemDAO;
import com.boss.demo.mytask.entity.po.ApplyForm;
import com.boss.demo.mytask.entity.po.FormItem;
import com.boss.demo.mytask.service.ApplyFormService;
import com.boss.demo.mytask.service.CartService;
import com.boss.demo.mytask.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author yuhangchen
 * @create 14/7/2020 上午11:29
 */
@Service
@Slf4j
public class ApplyFormServiceImpl implements ApplyFormService {
    @Autowired
    private CartService cartService;

    @Autowired
    private ApplyFormDAO applyFormDAO;

    @Autowired
    private FormItemDAO formItemDAO;

    /**
     *
     *
     * @description: 用于根据购物车存储的数据与其他数据生成订单数据，并存储在数据中。
     * @param {ApplyForm} applyForm
     * @return: {void}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    @Override
    public void settle(ApplyForm applyForm){
        FormItem formItem ;
        applyForm.setUuid(SnowFlake.nextId());
        applyFormDAO.insert(applyForm);
        ApplyForm applyForm1 =applyFormDAO.selectOne(applyForm);
        HashMap<Integer, FormItem> cart = cartService.getMyCart();
        Iterator cartIt = cart.keySet().iterator();
        while (cartIt.hasNext()) {
            Object key = cartIt.next();
            FormItem value = cart.get(key);
            value.setFormId(applyForm1.getFormId());
            formItemDAO.insert(value);
        }
    }

    @Override
    public ApplyForm listById (int formId){
        ApplyForm applyForm = applyFormDAO.selectById(formId);
        applyForm.setItems(formItemDAO.selectList(new EntityWrapper<FormItem>().eq("form_id", formId)));
        return applyForm;
    }


}
