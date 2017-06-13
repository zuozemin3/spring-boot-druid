package com.zzm.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.zzm.utils.ResultBuilder;
import com.zzm.utils.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.ReflectionException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResultVo handlerIllegalArgumentException(IllegalArgumentException exception) {
    return ResultBuilder.buildFail(exception.getMessage(), "999");
  }

  @ExceptionHandler(value = {NullPointerException.class, MySQLSyntaxErrorException.class,
      BadSqlGrammarException.class, MyBatisSystemException.class, ReflectionException.class})
  public ResultVo handlerRuntimeException(RuntimeException exception) {
    log.error(exception.getMessage(), exception);
    return ResultBuilder.buildFail("Internal Server Error", "500");
  }

  @ExceptionHandler(value = {Exception.class})
  public ResultVo handlerException(Exception exception) {
    log.error(exception.getMessage(), exception);
    return ResultBuilder.buildFail("system exception", "500");
  }
}
