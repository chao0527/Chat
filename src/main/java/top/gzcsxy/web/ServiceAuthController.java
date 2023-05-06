package top.gzcsxy.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 12:05]
 */
@SpringBootApplication
@ComponentScan("top.gzcsxy")
public class ServiceAuthController {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthController.class, args);
    }
}
