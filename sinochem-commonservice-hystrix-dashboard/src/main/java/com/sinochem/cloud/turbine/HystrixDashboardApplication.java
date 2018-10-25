package com.sinochem.cloud.turbine;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 
 * 
 * @project sinochem-cloud-hystrix-dashboard  
 * @description 
 * @author yekai <a href="mailto:yekairush@163.com">联系作者</a>
 * @version Revision:v1.0,Date:2017年12月25日
 * @Modification Date:2017年12月25日 {填写修改说明}
 */
@SpringBootApplication
@EnableTurbine
public class HystrixDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}
