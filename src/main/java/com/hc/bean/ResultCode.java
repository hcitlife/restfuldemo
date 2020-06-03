package com.hc.bean;

public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(200, "操作成功"),

    /**
     * 客户端错误
     */
    CLIENT_FAIL(400, "客户端错误"),

    /**
     * 服务器端错误
     */
    SERVER_FAIL(500, "服务器端错误"),

    PARAM_IS_INVALID(40001, "参数无效"),
    USER_NOT_LOGGED_IN(40002, "用户未登录，请先登录"),

    SYSTEM_INNER_ERROR(50001, "系统繁忙，请稍后重试"),

    PERMISSION_TOKEN_EXPIRED(70004, "token已过期"),
    PERMISSION_TOKEN_INVALID(70006, "无效token"),
    PERMISSION_SIGNATURE_ERROR(70007, "签名失败");

    /**
     * 操作代码
     */
    int code;
    /**
     * 提示信息
     */
    String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}