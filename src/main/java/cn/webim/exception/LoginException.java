package cn.webim.exception;

/**
 * 登录异常
 */
public class LoginException extends GeneralException {
    private static final int ERROR_CODE = 456;// 这里自定义该异常代码

    public LoginException(String message) {
        super(ERROR_CODE, message);
    }
}
