package cn.com.sm.exception;

import cn.com.sm.utils.BaseErrorInfo;

import java.io.Serializable;

/**
 * stock exception
 */
public class StockException extends RuntimeException implements Serializable {
    public static final long serialVersionUID = 1L;

    protected  String errorCode;

    protected String errorMsg;

    public StockException(){
        super();
    }

    public StockException(BaseErrorInfo err){
        super(err.getCode());
        this.errorCode = err.getCode();
        this.errorMsg = err.getMsg();
    }


    public StockException(BaseErrorInfo err, Throwable t){
        super(err.getCode(),t);
        this.errorCode = err.getCode();
        this.errorMsg = err.getMsg();
    }
    public StockException(String code,String msg){
        this.errorMsg = msg;
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
