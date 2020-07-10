package com.boss.demo.mytask.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * @Author yuhangchen
 * @create 9/7/2020 下午3:52
 */
@Data
@TableName("apply_form")
public class ApplyForm {
    /**
     * 申请清单ID
     */
    @TableId(type = IdType.AUTO)
    private int formId;
    /**
     * 申请部门
     */
    @TableField("apply_department")
    private String applyDepartment;
    /**
     * 申请日期
     */
    @TableField("apply_date")
    private String applyDate;
    /**
     *申请人
     */
    @TableField("applicant")
    private String applicant;
    /**
     *清单项
     */
    @TableField(exist = false)
    private HashMap<Long,FormItem> items;

    /**
     *总经理签批意见
     */
    @TableField("general_manager_opinion")
    private String generalManagerOpinion;
    /**
     *矿长审批意见
     */
    @TableField("barmaster_opinion")
    private String barmasterOpinion;
    /**
     *部门审批意见
     */
    @TableField("department_opinion")
    private String departmentOpinion;
    /**
     *仓库核查意见
     */
    @TableField("enterpot_opinion")
    private String enterpotOpinion;
    /**
     *采购部经办意见
     */
    @TableField("purchasing_opinion")
    private String purchasingOpinion;


}
