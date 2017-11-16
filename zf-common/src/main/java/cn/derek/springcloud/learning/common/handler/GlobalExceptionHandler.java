package cn.derek.springcloud.learning.common.handler;

import cn.derek.springcloud.learning.common.exception.BaseException;
import cn.derek.springcloud.learning.common.exception.InvalidTokenException;
import cn.derek.springcloud.learning.common.reponse.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;

@ControllerAdvice("cn.derek.springcloud.learning")
@ResponseBody
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(),ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(InvalidTokenException.class)
    public BaseResponse invalidTokenHandler(HttpServletResponse response, InvalidTokenException ex) {
        logger.error(ex.getMessage(),ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }
}
