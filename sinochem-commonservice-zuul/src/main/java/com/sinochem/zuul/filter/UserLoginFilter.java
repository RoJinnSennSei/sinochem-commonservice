package com.sinochem.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * 
 * @project sinochem-cloud-zuul-server
 * @description
 * @author yekai <a href="mailto:yekairush@163.com">联系作者</a>
 * @version Revision:v1.0,Date:2017年12月18日
 * @Modification Date:2017年12月18日 {填写修改说明}
 */
@Component
public class UserLoginFilter{
//public class UserLoginFilter extends ZuulFilter {
//
//	private static Logger logger = LoggerFactory
//			.getLogger(UserLoginFilter.class);
//
//	public Object run() {
//		RequestContext requestContext = RequestContext.getCurrentContext();
//		HttpServletRequest request = requestContext.getRequest();
//		logger.info(String.format("%s >>> %s", request.getMethod(), request
//				.getRequestURL().toString()));
//
//		Object userId = request.getParameter("userId");
//
//		if (userId == null) {
//			logger.warn("userId is empry, not allow to access website");
//			requestContext.setSendZuulResponse(false);
//			requestContext.setResponseStatusCode(401);
//			try {
//				requestContext.getResponse().getWriter()
//						.write("userId is empry, not allow to access website");
//			} catch (Exception e) {
//				logger.error("send response error", e);
//			}
//
//			return null;
//		}
//
//		logger.info("userId is ok, allow to access website");
//
//		return null;
//	}
//
//	public boolean shouldFilter() {
//		return true;
//	}
//
//	@Override
//	public int filterOrder() {
//		return 0;
//	}
//
//	@Override
//	public String filterType() {
//		return "pre";
//	}

}
