package com.black.ldchat.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author black
 */
@SpringBootApplication(scanBasePackages = {"com.black.ldchat"})
@MapperScan({"com.black.ldchat.common.**.mapper"})
@ServletComponentScan
public class ldchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ldchatApplication.class,args);
    }

}