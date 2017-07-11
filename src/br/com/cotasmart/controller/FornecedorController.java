package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.FornecedorDao;
import br.com.cotasmart.modelo.Fornecedor;

@Controller
public class FornecedorController {
	
	@RequestMapping("novoFornecedor")
	public String form(){
		return "fornecedor/adiciona";
	}
	
	@RequestMapping("adicionaFornecedor")
	public String adiciona(Fornecedor fornecedor){
		FornecedorDao dao = new FornecedorDao();
		dao.adiciona(fornecedor);
		return "fornecedor/lista";
	}
	
	@RequestMapping("listaFornecedor")
	public String lista(Model model){
		FornecedorDao dao = new FornecedorDao();
		model.addAttribute("fornecedores", dao.getLista());
		return "fornecedor/lista";
		
	}
}
