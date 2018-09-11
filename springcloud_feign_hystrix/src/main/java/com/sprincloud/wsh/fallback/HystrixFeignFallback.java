package com.sprincloud.wsh.fallback;

import com.sprincloud.wsh.feign.HystrixFeign;
import org.springframework.stereotype.Component;

/**
 * @Title: HystrixFeignFallback
 * @ProjectName springcloud_feign_hystrix
 * @Description: FeignClient失败回调方法
 * @Author WeiShiHuai
 * @Date 2018/9/11 10:28
 * FeignClient失败回调方法必须实现使用@FeignClient标识的接口（implements HystrixFeign），实现其中的方法
 */
@Component
public class HystrixFeignFallback implements HystrixFeign {

    /**
     * 由于某种原因使得服务调用不成功时会执行该回调方法
     *
     * @param name
     * @return
     */
    @Override
    public String getInfo(String name) {
        return "sorry " + name + ", feign client error";
    }

}
