package com.boss.demo.mytask.service;

import com.boss.demo.mytask.entity.po.ApplyForm;

/**
 * @Author yuhangchen
 * @create 9/7/2020 下午4:51
 */
public interface ApplyFormService {

   /**
    *
    *
    * @description: 用于根据购物车存储的数据与其他数据生成订单数据，并存储在数据中。
    * @param {ApplyForm} applyForm
    * @return: {void}
    * @author: YuHangChen
    * @time: 14/7/2020 上午10:17
    */
    public void settle(ApplyForm applyForm);

    /**
     *
     *
     * @description: 用于根据购物车存储的数据与其他数据生成订单数据，并存储在数据中。
     * @param {int} formId
     * @return: {ApplyForm}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public ApplyForm listById (int formId);

}
