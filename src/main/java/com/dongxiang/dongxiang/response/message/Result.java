package com.dongxiang.dongxiang.response.message;

/**
 * http返回的外层对象, 用来进行相应操作成功与否的提示
 */
public class Result<T> {
    // 错误码
    private Integer code;
    // 提示信息
    private String message;
    // 提示的具体内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
