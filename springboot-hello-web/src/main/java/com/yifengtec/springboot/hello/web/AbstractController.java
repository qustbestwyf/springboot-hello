package com.yifengtec.springboot.hello.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {
	
	@Autowired
	protected HttpServletRequest httpRequest;
	
	@Autowired
	protected HttpServletResponse httpResponse;
	
}
