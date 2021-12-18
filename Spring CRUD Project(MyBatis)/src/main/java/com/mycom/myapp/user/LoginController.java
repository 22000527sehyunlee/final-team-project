package com.mycom.myapp.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/loginOk",method=RequestMethod.POST)
	 public String loginCheck(HttpSession session,UserVO vo){
		System.out.println(vo.getPassword());
		 String returnURL = "";
		 if ( session.getAttribute("login") != null ){
		 session.removeAttribute("login");
		 }
		 UserVO user1 = new UserVO();
		 UserVO user2 = new UserVO();
		 UserVO loginvo = null;
		 user1.setUserid("seunghyun");
		 user1.setPassword("1234");
		 user2.setUserid("saehyun");
		 user2.setPassword("5678");
		 
		 if(user1.equals(vo)) loginvo = user1;
		 if(user2.equals(vo)) loginvo = user2;
		 
		 if ( loginvo != null ){ // 로그인 성공
			 System.out.println("로그인 성공!");
			 session.setAttribute("login", loginvo); 
			 returnURL = "redirect:/board/list"; 
		 }else { // 로그인 실패
			 System.out.println("로그인 실패!");
			 returnURL = "redirect:/login/"; 
		 }
		 return returnURL;
	 }
	 
	 // 로그아웃 하는 부분
	 @RequestMapping(value="/logout")
	 public String logout(HttpSession session) {
		 session.invalidate(); 
		 return "redirect:/login/"; 
	 }
}
