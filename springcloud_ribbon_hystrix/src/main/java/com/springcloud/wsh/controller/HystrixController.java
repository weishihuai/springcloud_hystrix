package com.springcloud.wsh.controller;

import com.springcloud.wsh.service.HystrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: HystrixController
 * @ProjectName springcloud_hystrix
 * @Description: 测试
 * @Author WeiShiHuai
 * @Date 2018/9/11 9:48
 */
@RestController
public class HystrixController {

    private static Logger logger = LoggerFactory.getLogger(HystrixController.class);

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping("/getInfo")
    public String getInfo(@RequestParam("name") String name) {
        return hystrixService.getInfo(name);
    }

}
