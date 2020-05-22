package cn.com.sm.util;

public enum ResultEnum implements BaseErrorInfo{
    SUCCESS("200","success"),
    NOT_FOUND("404","resource not found"),
    SERVER_INTERNAL_ERRO("500","server internal error"),
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
