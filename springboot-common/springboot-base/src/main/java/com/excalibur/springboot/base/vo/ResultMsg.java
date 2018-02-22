package com.excalibur.springboot.base.vo;

/**
 * http请求返回的最外层对象
 *
 * @author: mingfa.zheng
 * @date: 2018/2/17 10:45
 */
public class ResultMsg {

    /** 返回结果(ok=成功，非ok都是失败,fail) */
    private String ret = "ok";

    /** 提示信息 */
    private String msg = "common_op_succeed";

    /** 具体的内容 */
    private Object data;

    public ResultMsg() {
        super();
    }

    public ResultMsg(Object data) {
        super();
        this.data = data;
    }

    public ResultMsg(String ret, String msg) {
        super();
        this.ret = ret;
        this.msg = msg;
    }

    public ResultMsg(String ret, String msg, Object data) {
        super();
        this.ret = ret;
        this.msg = msg;
        this.data = data;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
