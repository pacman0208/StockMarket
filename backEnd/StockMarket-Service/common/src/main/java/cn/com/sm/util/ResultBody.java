package cn.com.sm.util;

import cn.com.sm.exception.StockException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultBody {
    private String code;

    private String msg;

    private Object result;

    /**
     * default constructor
     */
    public ResultBody() {
    }

    /**
     * constructor with parameters
     * @param code
     * @param msg
     * @param result
     */
    public ResultBody(String code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getResult() {
        return result;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * success wrap without data
     * @return
     */
    public static ResultBody success(){
        return success(null);
    }

    /**
     * success wrap
     * @param data
     * @return
     */
    public static ResultBody success(Object data){
        ResultBody result = new ResultBody();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setResult(data);
        return result;
    }

    /**
     * error wrap
     * @param bei
     * @return
     */
    public static ResultBody error(BaseErrorInfo bei){
        ResultBody rb = new ResultBody();
        rb.setCode(bei.getCode());
        rb.setMsg(bei.getMsg());
        return rb;
    }

    public static ResultBody error(String code ,String msg){
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMsg(msg);
        return rb;
    }

    @Override
    public String toString() {
        ObjectMapper mapper =  new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        ResultBody rb = new ResultBody();
        rb.setMsg("not found");
        rb.setCode("404");
        System.out.println(rb);
    }
}
