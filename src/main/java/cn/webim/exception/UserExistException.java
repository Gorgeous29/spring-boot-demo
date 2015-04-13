package cn.webim.exception;

/**
 * 注册异常
 */
public class UserExistException extends GeneralException {
    private static final int ERROR_CODE = 457;// 这里自定义该异常代码

    public UserExistException(String message) {
        super(ERROR_CODE, message);
    }
}
