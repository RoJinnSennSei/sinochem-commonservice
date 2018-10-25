package com.sinochem.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * 
 * @project sinochem-cloud-eureka
 * @description 服务发现中心
 * @author yekai <a href="mailto:yekairush@163.com">联系作者</a>
 * @version Revision:v1.0,Date:2017年12月18日
 * @Modification Date:2017年12月18日 {填写修改说明}
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
		System.out.println("EurekaServiceApplication 启动成功！");
	}

}