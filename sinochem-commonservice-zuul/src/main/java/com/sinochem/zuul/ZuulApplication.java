package com.sinochem.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * 
 * @project sinochem-cloud-zuul-server
 * @description 提供动态路由，监控，弹性，安全等的边缘服务
 * @author yekai <a href="mailto:yekairush@163.com">联系作者</a>
 * @version Revision:v1.0,Date:2017年12月18日
 * @Modification Date:2017年12月18日 {填写修改说明}
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
		System.out.println("ZuulApplication 启动成功！");
	}

}
