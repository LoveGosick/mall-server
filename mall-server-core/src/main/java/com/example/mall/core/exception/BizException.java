package com.example.mall.core.exception;

import com.example.mall.core.enums.StatusCode;

/**
 * 统一运行时异常
 *
 * @author huangyihang
 * @version 1.0
 * @date 2023-01-18
 */
public class BizException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String code;

  public BizException() {
  }

  public BizException(String message) {
    super(message);
  }

  public BizException(Throwable cause) {
    super(cause);
  }

  public BizException(String message, Throwable cause) {
    super(message, cause);
  }

  public BizException(StatusCode statusCode) {
    this(statusCode.getCode(), statusCode.getMessage());
  }

  public BizException(String code, String message) {
    super(message);
    this.code = code;
  }

  public BizException(StatusCode statusCode, Object... args) {
    this(statusCode.getCode(), statusCode.getMessage(), args);
  }

  public BizException(String code, String messageFormat, Object... args) {
    super(String.format(messageFormat, args));
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
