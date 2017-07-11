package com.yifengtec.springboot.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(path = "/auth")
@Controller
public class AuthorizeController {

	@RequestMapping(path = "/403")
	public ModelAndView noAuthrized() throws Exception {
		return new ModelAndView("/auth/403");
	}

}
