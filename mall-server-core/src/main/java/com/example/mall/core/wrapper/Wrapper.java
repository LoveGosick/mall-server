package com.example.mall.core.wrapper;

import com.example.mall.core.enums.StatusCode;
import com.example.mall.core.exception.BizException;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Data;

/**
 * 统一响应结果
 *
 * @author huangyihang
 * @version 1.0
 * @date 2023-01-18
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class Wrapper<T extends Serializable> implements Serializable {

  private static final long serialVersionUID = 1L;

  private String code;
  private String message;
  private T data;

  public Wrapper() {
    this(StatusCode.SUCCESS);
  }

  public Wrapper(StatusCode statusCode) {
    this(statusCode.getCode(), statusCode.getMessage());
  }

  public Wrapper(String code, String message) {
    this(code, message, null);
  }

  public Wrapper(String code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public boolean success() {
    return StatusCode.SUCCESS.getCode().equals(this.code);
  }

  public boolean error() {
    return !this.success();
  }

  public Wrapper<T> check() {
    if (this.error()) {
      if (StatusCode.ERROR.getCode().equals(this.code)) {
        // 避免开发者不规范使用 StatusCode.ERROR 状态码
        throw new BizException(StatusCode.ERROR);
      } else {
        throw new BizException(this.code, this.message);
      }
    }

    return this;
  }

}
