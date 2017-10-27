package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
@Transactional
@Controller
public class GeralController {

	
	@RequestMapping("inicio")
	public String form(){
		return "geral/inicio";
	}
}
