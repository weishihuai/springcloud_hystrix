package com.sprincloud.wsh.controller;

import com.sprincloud.wsh.feign.HystrixFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: HystrixFeignController
 * @ProjectName springcloud_feign_hystrix
 * @Description: 测试Feign
 * @Author WeiShiHuai
 * @Date 2018/9/11 10:28
 * 注入FeignClient，调用feignClient的方法实现远程方法调用
 */
@RestController
public class HystrixFeignController {

    private static Logger logger = LoggerFactory.getLogger(HystrixFeignController.class);

    @Autowired
    private HystrixFeign hystrixFeign;

    /**
     * 使用http://localhost:5555/getInfo?name=xxx访问，实际上会通过FeignClient调用服务hystrix-service提供的getInfo接口
     *
     * @param name
     * @return
     */
    @GetMapping("/getInfo")
    public String getInfo(@RequestParam("name") String name) {
        String info = hystrixFeign.getInfo(name);
        logger.info(info);
        return info;
    }

}
