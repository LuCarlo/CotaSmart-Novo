package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.ProdutoDao;

@Controller
public class ProdutoController {
	
	@RequestMapping("listaProduto")
	public String lista(Model model){
		ProdutoDao dao = new ProdutoDao();
		model.addAttribute("produtos", dao.getLista());
		
		return "produto/lista";
		
	}
	@RequestMapping("novoProduto")
	public String form(){
		return "produto/adiciona";
	}
	
	
}
