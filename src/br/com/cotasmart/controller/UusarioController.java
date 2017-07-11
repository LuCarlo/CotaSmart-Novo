package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UusarioController {

	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/adiciona";
	}
}
