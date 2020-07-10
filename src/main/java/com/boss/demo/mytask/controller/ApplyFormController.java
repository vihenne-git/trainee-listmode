package com.boss.demo.mytask.controller;

import com.boss.demo.mytask.entity.ApplyForm;
import com.boss.demo.mytask.entity.FormItem;
import com.boss.demo.mytask.service.ApplyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yuhangchen
 * @create 9/7/2020 下午3:49
 */
@RestController
@RequestMapping("/form")
public class ApplyFormController {
    @Autowired
    private ApplyFormService applyFormService;

    @RequestMapping("/list")
    public String list(@RequestBody ApplyForm applyForm){
        return applyFormService.listById(applyForm.getFormId());
    }


}
