package com.sinochem.cloud.sleuth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * 
 * 
 * @project sinochem-cloud-sleuth-server
 * @description 服务链路追踪
 * @author yekai <a href="mailto:yekairush@163.com">联系作者</a>
		* @version Revision:v1.0,Date:2017年12月18日
		* @Modification Date:2017年12月18日 {填写修改说明}
		*/
@SpringBootApplication
@EnableZipkinServer
public class SleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
		System.out.println("SleuthApplication 启动成功！");
	}

}