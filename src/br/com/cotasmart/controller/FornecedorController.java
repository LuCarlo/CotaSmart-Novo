package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FornecedorController {
	
	@RequestMapping("novoFornecedor")
	public String form(){
		return "";
	}

}
