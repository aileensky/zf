package cn.derek.springcloud.learning.common.reponse;

import cn.derek.springcloud.learning.common.Constants;

/**
 * Created by ace on 2017/8/23.
 */
public class BaseResponse {
    private int status = Constants.BASE_RESPONSE_OK;
    private String message;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static BaseResponse ok(String message){
        return new BaseResponse(Constants.BASE_RESPONSE_OK, message);
    }
}
