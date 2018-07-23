package com.zxz.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zxz.utils.Constants;
import com.zxz.utils.RedisAPI;

public class SysInterceptor implements HandlerInterceptor {
	@Resource
	private RedisAPI redisAPI;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// intercept
		HttpSession session = request.getSession();
		Object user = ((Object) session.getAttribute(Constants.SESSION_USER));
		if (null == user) {
			response.sendRedirect(request.getContextPath());
			return false;
		} else {
			response.sendRedirect(request.getContextPath() + "/401.html");
			return false;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
}
