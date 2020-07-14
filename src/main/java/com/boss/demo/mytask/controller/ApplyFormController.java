package com.boss.demo.mytask.controller;

import com.boss.demo.mytask.entity.po.ApplyForm;
import com.boss.demo.mytask.utils.ReturnResult;
import com.boss.demo.mytask.service.ApplyFormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yuhangchen
 * @create 9/7/2020 下午3:49
 */
@Slf4j
@RestController
@RequestMapping("/form")
public class ApplyFormController {
    @Autowired
    private ApplyFormService applyFormService;

    /**
     *
     *
     * @description: 按申请单ID查询申请单的接口
     * @param {ApplyForm} applyForm
     * @return: { ReturnResult}
     * @author: YuHangChen
     * @time: 14/7/2020 下午2:55
     */
    @PostMapping("/list")
    @Transactional(rollbackFor = Exception.class)
    public ReturnResult list(@RequestBody ApplyForm applyForm){
        ApplyForm data = applyFormService.listById(applyForm.getFormId());
        if(data !=null){
            return ReturnResult.success(200,"查询成功",data);
        }else {
            return ReturnResult.fail(404,"查询失败",data);
        }

    }


    /*@RequestMapping("/test")
    public String test_cookie(HttpServletResponse response){
        response.addCookie(new Cookie("testUser", "vihenne"));
        return "cookies";
    }
    @RequestMapping("/testSession")
    @ResponseBody
    public String testSession(HttpSession session){
        session.setAttribute("testSession","this is my session");
        return "testSession";
    }


    @RequestMapping("/testGetSession")
    @ResponseBody
    public String testGetSession(HttpSession session){
        Object testSession = session.getAttribute("testSession");
        return String.valueOf(testSession);
    }*/

}
