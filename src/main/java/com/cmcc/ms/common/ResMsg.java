package com.cmcc.ms.common;

/**
 * @author chiwei
 */
public enum ResMsg {

    SUCCESS(100, "成功"),
    
    PARAM_ERROR(200,"参数异常"),

    FAIL(500,"系统异常"),;

    private int code;
    private String msg;

    ResMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
