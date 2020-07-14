package com.boss.demo.mytask.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author yuhangchen
 * @create 14/7/2020 下午2:02
 */
@Data
@ApiModel(value="返回信息映射类")
public class ReturnResult {
    /**
     *封装的返回数据
     */
    @ApiModelProperty(value="返回数据")
    private Object data;

    /**
     *封装的状态码
     */
    @ApiModelProperty(value="返回状态码")
    private Integer code;

    /**
     *封装的返回信息提示
     */
    @ApiModelProperty(value="返回信息提示")
    private String msg;


    private ReturnResult(Integer code, String msg,Object data) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    private ReturnResult(Object data) {
        this.data = data;
        this.code = 0;
        this.msg = "success";
    }

    private ReturnResult(Integer code,String msg){
        this.code =  code;
        this.msg = msg;
    }


    public ReturnResult() {
        this.code = 0;
        this.msg = "success";
    }

    /***
     * 输入参数:
     *
     *
     * @param data
     * @param code
     * @param msg
     * @return 返回成功，包含total、code、msg、data
     */
    public static ReturnResult success(Integer code, String msg,Object data) {
        return new ReturnResult(code,msg,data);
    }

    public static ReturnResult success(Integer code,String msg){
        return new ReturnResult(code,msg);
    }

    public static ReturnResult error(Integer code,String msg){
        return new ReturnResult(code,msg);
    }


    /***
     * 输入参数：
     *
     * @param data
     * @return 返回成功，包含code、msg、data
     */
    public static ReturnResult success(Object data) {
        return new ReturnResult(data);
    }

    public static ReturnResult success(){
        return new ReturnResult();
    }

    /***
     * 输入参数：
     *
     * @param data
     * @return 返回失败，包含code、msg、data
     */
    public static ReturnResult fail(Integer code, String msg,Object data) {
        return new ReturnResult(code,msg,data);
    }
}
