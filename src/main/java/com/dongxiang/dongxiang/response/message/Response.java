package com.dongxiang.dongxiang.response.message;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private RespMeta meta;
    private Map<String, Object> data;

    /**
     * @param name   data name
     * @param object data object
     * @return this response
     */
    public Response addData(String name, Object object) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(name, object);
        return this;
    }

    public RespMeta getMeta() {
        return meta;
    }

    public void setMeta(RespMeta meta) {
        this.meta = meta;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}