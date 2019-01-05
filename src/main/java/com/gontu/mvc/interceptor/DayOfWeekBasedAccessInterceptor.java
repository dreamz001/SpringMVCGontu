package com.gontu.mvc.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar cal=Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		System.out.println("day of week................."+dayOfWeek);
		if( dayOfWeek== 3 || dayOfWeek == 4) {// 1 means sunday, 7 means saturday
			String resp="The website is closed on weekends, please try accessing it on weekdays.";
			response.getWriter().write(resp);
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// this method will be called after the request has been processed(before creating html or view file)
		System.out.println("Spring MVC postHandle method has been called : "+request.getRequestURI().toString());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// this method will be called after creating the response(html or view file)
		System.out.println("Spring MVC afterCompletion method called : "+request.getRequestURI().toString());
	}
}
