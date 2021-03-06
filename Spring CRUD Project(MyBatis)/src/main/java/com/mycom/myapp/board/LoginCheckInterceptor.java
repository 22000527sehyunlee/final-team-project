package com.mycom.myapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		if (obj == null) {
			System.out.println("로그인 하셔야죠!");
			response.sendRedirect(request.getContextPath() + "/login/");
			return false;
		}
		System.out.println("로그인 하셨군요!");
		return true;
	}
}
