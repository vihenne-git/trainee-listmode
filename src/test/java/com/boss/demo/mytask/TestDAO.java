package com.boss.demo.mytask;

import com.boss.demo.mytask.dao.ApplyFormDAO;
import com.boss.demo.mytask.dao.FormItemDAO;
import com.boss.demo.mytask.entity.ApplyForm;
import com.boss.demo.mytask.entity.FormItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author asus
 * @create 10/7/2020 上午9:48
 */
@SpringBootTest
public class TestDAO {
    @Autowired
    private FormItemDAO formItemDAO;
    @Autowired
    private ApplyFormDAO applyFormDAO;
    @Test
    public void Test(){
        FormItem formItem = new FormItem();
        formItem.setFormId(1);
        formItem.setItemId(10);
        formItem.setName("解决");
        //formItemDAO.insert(formItem);
    }
    @Test
    public void TestApplyForm(){

        ApplyForm applyForm = new ApplyForm();
        applyForm.setApplyDepartment("sajosaoisain");
        applyForm.setFormId(5);
        applyForm.setApplyDepartment("sss");
        applyForm.setPurchasingOpinion("wu");
        applyForm.setEnterpotOpinion("wu");
        applyForm.setDepartmentOpinion("wu");
        applyForm.setBarmasterOpinion("wu");
        applyForm.setGeneralManagerOpinion("wu");
        applyForm.setApplicant("wu");
        applyForm.setApplyDate("2020");
        System.out.println(applyForm.toString());
        //applyFormDAO.insert(applyForm);
    }
}
