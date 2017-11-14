package cn.derek.springcloud.learning.admin.common.exception;

import cn.derek.springcloud.learning.admin.common.Constants;

public class InvalidTokenException extends BaseException {

    public InvalidTokenException(String message) {
        super(message, Constants.EX_INVALID_TOKEN);
    }
}
