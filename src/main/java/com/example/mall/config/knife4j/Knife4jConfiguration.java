package com.example.mall.config.knife4j;

import com.example.mall.constant.GlobalConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Knife4j 配置
 *
 * @author huangyihang
 * @version 1.0
 * @date 2023-01-17
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

  @Bean(value = "dockerBean")
  public Docket dockerBean() {
    //指定使用Swagger2规范
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(new ApiInfoBuilder()
            //描述字段支持Markdown语法
            .description("# Knife4j RESTful APIs")
            .termsOfServiceUrl("https://doc.xiaominfo.com/")
            .contact("xiaoymin@foxmail.com")
            .version("1.0")
            .build())
        //分组名称
        .groupName(GlobalConstant.SPRING_APPLICATION_NAME)
        .select()
        //这里指定Controller扫描包路径
        .apis(RequestHandlerSelectors.basePackage("com.example.mall.controller"))
        .paths(PathSelectors.any())
        .build();
  }
}