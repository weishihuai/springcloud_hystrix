package com.sprincloud.wsh.feign;

import com.sprincloud.wsh.fallback.HystrixFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Title: HystrixFeign
 * @ProjectName springcloud_hystrix
 * @Description:
 * @Author WeiShiHuai
 * @Date 2018/9/11 10:25
 */
@FeignClient(value = "hystrix-service", fallback = HystrixFeignFallback.class)
public interface HystrixFeign {

    @RequestMapping("/getInfo")
    String getInfo(@RequestParam("name") String name);

}
