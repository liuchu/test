package me.liuchu.test.boottest.model.dto.response;

import lombok.Data;

/**
 * @author liuchu
 * Date 2019/5/22
 * Time 17:00
 */
@Data
public class Response {

    private Integer respCode;
    private String respDesc;
    private Object data;

    private static final Integer SUCCESS_CODE = 200;
    private static final String DEFAULT_SUCCESS_MSG = "success";

    public Response(Integer respCode, String respDesc, Object data) {
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.data = data;
    }

    public static Response ok(Integer respCode, String respDesc, Object data) {
        return new Response(respCode, respDesc, data);
    }

    public static Response ok(Integer code, String respDesc) {
        return ok(code, respDesc, null);
    }

    public static Response ok(Integer respCode) {
        return ok(respCode, DEFAULT_SUCCESS_MSG);
    }

    public static Response ok(){
        return ok(SUCCESS_CODE);
    }
}
