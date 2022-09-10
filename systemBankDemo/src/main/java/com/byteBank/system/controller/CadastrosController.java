package com.byteBank.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CadastrosController {

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Teste do sistema";
	}
}
