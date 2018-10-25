/**
 * 
 */
package com.sinochem.mq.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
public class MonitorController {
	
	private static Logger logger = Logger.getLogger(MonitorController.class);

    @GetMapping("/applicationRun")
    public String applicationRun() throws Exception{
    	
    	logger.info("MqApplication 启动成功！服务正常");
    	
        return "OK";
    }
    
}
