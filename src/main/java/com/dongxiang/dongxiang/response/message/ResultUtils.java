package com.dongxiang.dongxiang.response.message;

/**
 * 成功或者错误信息异常的工具类
 */
public class ResultUtils {
    /**
     * 成功的提示类别
     * @param message 提示信息
     * @param code 状态码
     * @param object 相应的对象
     * @return 对应Result实体
     */
    public static Result success(String message, Integer code, Object object) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(object);
        return result;
    }

    /**
     * 失败的提示类别
     * @param message 提示信息
     * @param code 状态码
     * @return 对应Result实体
     */
    public static Result error(String message, Integer code) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
