package com.example.mall.core.enums;

import lombok.Getter;

/**
 * 统一状态码
 *
 * @author huangyihang
 * @version 1.0
 * @date 2023-01-18
 */
@Getter
public enum StatusCode {

  C00000("C00000", "禁止调用类%s的私有构造方法"),

  SUCCESS("000000", "OK"),
  ERROR("999999", "系统繁忙");

  private String code;
  private String message;

  StatusCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
