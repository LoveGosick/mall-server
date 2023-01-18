package com.example.mall.core.constant;

import com.example.mall.core.enums.StatusCode;
import com.example.mall.core.exception.BizException;

/**
 * 全局常量
 *
 * @author huangyihang
 * @version 1.0
 * @date 2023-01-17
 */
public class GlobalConstant {

  private GlobalConstant() {
    // 禁止调用私有构造方法
    throw new BizException(StatusCode.C00000, this.getClass().getName());
  }

  /**
   * 应用名称 spring.application.name
   */
  public static final String SPRING_APPLICATION_NAME = "mall-server";

}
