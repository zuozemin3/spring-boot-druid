package com.zcx.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.zcx.utils.ResultBuilder;
import com.zcx.utils.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(IllegalArgumentException.class)
  public ResultVo handlerIllegalArgumentException(IllegalArgumentException exception) {
    return ResultBuilder.buildFail(exception.getMessage(), "400");
  }

  @ExceptionHandler(value = {NullPointerException.class, MySQLSyntaxErrorException.class})
  public ResultVo handlerException(RuntimeException exception) {
    log.error(exception.getMessage(), exception);
    return ResultBuilder.buildFail("Internal Server Error", "500");
  }
}
