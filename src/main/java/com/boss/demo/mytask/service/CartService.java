package com.boss.demo.mytask.service;

import com.boss.demo.mytask.entity.po.ApplyForm;
import com.boss.demo.mytask.entity.po.FormItem;

import java.util.HashMap;

/**
 * @Author yuhangchen
 * @create 9/7/2020 下午4:52
 */
public interface CartService {

    /**
     *
     *
     * @description: 用于向购物车添加货品。
     * @param {FormItem} formItem
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean add(FormItem formItem);

    /**
     *
     *
     * @description: 用于去除购物车的货品。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean remove(int itemId);

    /**
     *
     *
     * @description: 用于修改购物车的货品。
     * @param {FormItem} formItem
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean edit(FormItem formItem);

    /**
     *
     *
     * @description: 用于查看购物车所有货品数据。
     * @return: {String}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public String list();

    /**
     *
     *
     * @description: 用于生成订单。
     * @param {ApplyForm} applyForm
     * @return: {String}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public String settle(ApplyForm applyForm);

    /**
     *
     *
     * @description: 用于获取购物车对象
     * @return: {HashMap<Integer, FormItem>}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public HashMap<Integer, FormItem> getMyCart();

}
