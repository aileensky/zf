package cn.derek.springcloud.learning.common.exception;

public class BaseException extends RuntimeException {

    private int status = 200;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }
}
