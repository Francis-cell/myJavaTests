package com.zmr.ResponseTest.Controller.nginx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> nginx 测试调用接口 </p>
 */
@RestController
@RequestMapping("/nginxTest")
public class NginxTestDemoController {
    // 同步请求部分
    @GetMapping("/hello")
    public String helloRequest() {
        return "Hello, here is nginx!";
    }
}
