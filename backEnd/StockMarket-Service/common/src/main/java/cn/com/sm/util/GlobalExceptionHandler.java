package cn.com.sm.util;

import cn.com.sm.exception.StockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = StockException.class)
    @ResponseBody
    public ResultBody handleBusinessExp(StockException e){
        logger.error("Business exception happened:"+e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());

    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(Exception e){
        logger.error("exception happened:"+e);
        e.printStackTrace();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return ResultBody.error(ResultEnum.NOT_FOUND);
        }
        return ResultBody.error(ResultEnum.SERVER_INTERNAL_ERRO);

    }


    @ExceptionHandler(value={NoHandlerFoundException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    /**
     * handle with 404
     */
    public ResultBody handleNotFoundExp(Exception e){
        logger.error(e.toString());
        return ResultBody.error(ResultEnum.NOT_FOUND);
    }

//    @Override
//    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return super.handleNoHandlerFoundException(ex, headers, status, request);
//    }
}
