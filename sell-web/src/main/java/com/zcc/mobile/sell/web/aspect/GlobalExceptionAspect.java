package com.zcc.mobile.sell.web.aspect;

import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.web.enums.ResponseStatusEnum;
import com.zcc.mobile.sell.web.vo.SellResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@RestControllerAdvice
public class GlobalExceptionAspect {

    @ResponseBody
    @ExceptionHandler(SellException.class)
    public SellResponse<Object> sellException(SellException sellException) {
        return SellResponse.builder().code(ResponseStatusEnum.FAILURE.getCode())
                .message(sellException.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public SellResponse<Object> validateException(MethodArgumentNotValidException validationException) {
        return SellResponse.builder().code(ResponseStatusEnum.FAILURE.getCode())
                .message(validationException.getBindingResult().getAllErrors()
                        .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining("; "))).build();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public SellResponse<Object> commonException(Exception exception) {
        return SellResponse.builder().code(ResponseStatusEnum.FAILURE.getCode())
                .message(exception.getMessage()).build();
    }
}
