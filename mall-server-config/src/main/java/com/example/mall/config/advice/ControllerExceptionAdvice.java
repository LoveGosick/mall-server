package com.example.mall.config.advice;

import com.example.mall.core.exception.BizException;
import com.example.mall.core.wrapper.WrapMapper;
import com.example.mall.core.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller 统一异常拦截
 *
 * @author huangyihang
 * @version 1.0
 * @date 2023-01-18
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

  /**
   * BizException
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value = {BizException.class})
  public Wrapper bizExceptionHandler(BizException e) {
    // 打印日志
    printExceptionLog(e);
    // 返回响应结果
    return WrapMapper.error(e.getCode(), e.getMessage());
  }

  /**
   * Exception
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value = {Exception.class})
  public Wrapper finalExceptionHandler(Exception e) {
    // 打印日志
    printExceptionLog(e);
    // 返回响应结果
    return WrapMapper.error();
  }

  /**
   * 打印异常信息日志
   */
  private void printExceptionLog(Exception e) {
    log.error(e.toString(), e);
  }

}
