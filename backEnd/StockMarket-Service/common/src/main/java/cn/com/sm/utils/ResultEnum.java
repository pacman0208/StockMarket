package cn.com.sm.utils;

public enum ResultEnum implements BaseErrorInfo{
    SUCCESS("200","success"),
    NOT_FOUND("404","resource not found"),
    SERVER_INTERNAL_ERROR("500","server internal error"),
    CUSTOM_USER_PWD_NOT_FOUND("900","User/password is not correct"),
    TOKEN_INVALIDATE("901","Token invalidate"),
    NOT_LOGIN("902","Please login first"),
    PASSWORD_NOT_MATCH("903","Confirm password not match the original password"),
    TOKEN_EXPIRED("904","Token has expired"),
    SERVER_BUSY("503","server busy");


    private String code;

    private String msg;


    ResultEnum(String code,String msg){
        this.code=code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
