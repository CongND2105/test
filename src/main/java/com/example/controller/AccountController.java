package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.service.CookieService;
import com.example.service.ParamService;
import com.example.service.SessionService;


@Controller

public class AccountController {
	
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;
	

	@GetMapping("/account/login")
		public String login1() {
		
			return "login";
		}
	
	@PostMapping("/account/login")
		public String login2() {
		
			String un = paramService.getString("username","");
			String pw = paramService.getString("password","");
			boolean rm = paramService.getBoolean("remember", false);
			if(un.equals("teo") && pw.equals("123")) {
//				sessionService.set("username",un);
				if(rm) {
					cookieService.create("username",un, 10);
					cookieService.create("password",pw, 10);
				}else {
					cookieService.remove(un);
					cookieService.remove(pw);
				}
			}else {
				System.out.println("dang nhap that bai");
			}
			
		
			return "login";
	}
	
}
