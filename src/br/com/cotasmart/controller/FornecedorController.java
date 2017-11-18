package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.FornecedorDao;
import br.com.cotasmart.modelo.Fornecedor;

@Transactional
@Controller
public class FornecedorController {

	@RequestMapping("novoFornecedor")
	public String form(Model model) {
		return "forward:listaUsuarioTelaFornecedor";
		
	}

	@RequestMapping("adicionaFornecedor")
	public String adiciona(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();
		dao.adiciona(fornecedor);
		return "redirect:listaFornecedor";
//		return "fornecedor/adicionaSucesso";
	}

	@RequestMapping("listaFornecedor")
	public String lista(Model model) {
		FornecedorDao dao = new FornecedorDao();
		model.addAttribute("fornecedores", dao.getLista());
		return "fornecedor/lista";

	}

	@RequestMapping("alteraFornecedor")
	public String altera(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();
		dao.altera(fornecedor);
		return "redirect:listaFornecedor";
	}

	@RequestMapping("mostraFornecedor")
	public String mostra(Long codFornecedor, Model model) {
		FornecedorDao dao = new FornecedorDao();
		model.addAttribute("fornecedores", dao.buscaPorId(codFornecedor));
		
		return("fornecedor/mostra");
	}

	@RequestMapping("ativaFornecedor")
	public String ativa(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();
		dao.ativaFornecedor(fornecedor.getCodFornecedor());
		return "redirect:listaFornecedor";
	}

	@RequestMapping("desativaFornecedor")
	public String desativa(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();
		dao.desativaFornecedor(fornecedor.getCodFornecedor());
		return "redirect:listaFornecedor";
	}
}
