package com.boss.demo.mytask.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yuhangchen
 * @create 9/7/2020 下午3:52
 */
@Data
@TableName("form_item")
public class FormItem {
    /**
     * 申请清单项ID
     */
    @TableId("item_id")
    private int itemId;
    /**
     * 申请清单ID
     */
    @TableField("form_id")
    private int formId;
    /**
     * 品名
     */
    @TableField("name")
    private String name;
    /**
     * 规格型号
     */
    @TableField("specification")
    private  String specification;
    /**
     * 数量
     */
    @TableField("amount")
    private  int amount;
    /**
     * 用途地点
     */
    @TableField("use_site")
    private String useSite;
    /**
     * 需要时间
     */
    @TableField("need_data")
    private String needData;

}
