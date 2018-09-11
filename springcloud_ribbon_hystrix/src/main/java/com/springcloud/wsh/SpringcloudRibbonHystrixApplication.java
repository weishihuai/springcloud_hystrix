package com.springcloud.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 应用程序启动类
 * @Author: WeiShiHuai
 * @Date: 2018/9/11 9:37
 * Spring Cloud中服务之间的调用方式主要有两种，一种是Ribbon+RestTemplate,一种是Feign声明式服务调用，在实际项目中，为了服务高可用，一个服务通常会集群部署，运行多个实例，
 * 由于网络原因或者服务自身原因，被调用的服务并不能保证100%请求成功，如果这时候有大量的请求请求这个故障的服务，由于服务之间的依赖关系，故障会进行蔓延，这时候会导致调用服务自身也出现不可用的情况，使用Hystrix可以解决这个问题
 * 当某个服务单元发生故障（类似用电器发生短路）之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个错误响应，而不是长时间的等待。这样就不会使得线程因调用故障服务被长时间占用不释放，避免了故障在分布式系统中的蔓延。
 * <p>
 * “雪崩效应”: 因 '服务提供者' 的不可用导致 '服务调用者' 的不可用,并将不可用逐渐放大的过程
 */
@SpringBootApplication
@EnableDiscoveryClient
// @EnableHystrix 与 @EnableCircuitBreaker注解用于开启Hystrix断路器功能
//@EnableHystrix
@EnableCircuitBreaker
//@EnableHystrixDashboard注解开启Hystrix仪表盘功能，监控请求情况
//通过Hystrix Dashboard可以直接看到各个Hystrix Command的请求响应时间，请求成功率等数据
@EnableHystrixDashboard
//@SpringCloudApplication = @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
public class SpringcloudRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonHystrixApplication.class, args);
    }

    /**
     * 开启Ribbon负载均衡能力，并注入spring容器
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
