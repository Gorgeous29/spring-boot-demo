package cn.webim.exception;

/**
 * 异常基类
 */
public class GeneralException extends RuntimeException {
    protected int code;

    public GeneralException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
