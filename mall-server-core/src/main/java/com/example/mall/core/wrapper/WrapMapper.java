package com.example.mall.core.wrapper;

import com.example.mall.core.enums.StatusCode;
import com.example.mall.core.exception.BizException;
import java.io.Serializable;

/**
 * Wrapper 构造类
 *
 * @author huangyihang
 * @version 1.0
 * @date 2023-01-18
 */
public class WrapMapper {

  private WrapMapper() {
    // 禁止调用私有构造方法
    throw new BizException(StatusCode.C00000, this.getClass().getName());
  }

  public static Wrapper success() {
    return new Wrapper<>();
  }

  public static <E extends Serializable> Wrapper<E> success(E data) {
    return wrap(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), data);
  }

  public static Wrapper error() {
    return new Wrapper<>(StatusCode.ERROR);
  }

  public static Wrapper error(StatusCode statusCode) {
    return new Wrapper<>(statusCode);
  }

  public static Wrapper error(String code, String message) {
    return new Wrapper<>(code, message);
  }

  public static <E extends Serializable> Wrapper<E> wrap(String code, String message, E data) {
    return new Wrapper<>(code, message, data);
  }

}
