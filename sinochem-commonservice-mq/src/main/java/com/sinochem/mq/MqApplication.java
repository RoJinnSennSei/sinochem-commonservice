package com.sinochem.mq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @project sinochem-cloud-eureka
 * @description 服务发现中心
 * @author yekai <a href="mailto:yekairush@163.com">联系作者</a>
 * @version Revision:v1.0,Date:2017年12月18日
 * @Modification Date:2017年12月18日 {填写修改说明}
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.sinochem")
@ComponentScan(basePackages = "com.sinochem")
public class MqApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MqApplication.class, args);
		System.out.println("MqApplication 启动成功！");
	}
}
