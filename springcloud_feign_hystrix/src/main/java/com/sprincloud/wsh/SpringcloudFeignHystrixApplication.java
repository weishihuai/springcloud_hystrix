package com.sprincloud.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/** 
 * @Description: 应用程序启动类
 * @Author: WeiShiHuai  
 * @Date: 2018/9/11 10:23
 *
 * Feign默认集成了Hystrix,所以只需要加入Feign的依赖即可。
 * Feign是通过@FeignClient()中指定fallback来实现Hystrix断路器功能的，当远程服务调用失败的时候就会执行这个回调方法。
 *
*/
@SpringBootApplication
@EnableDiscoveryClient
//开启Feign声明式服务调用功能
@EnableFeignClients
public class SpringcloudFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudFeignHystrixApplication.class, args);
	}
}
