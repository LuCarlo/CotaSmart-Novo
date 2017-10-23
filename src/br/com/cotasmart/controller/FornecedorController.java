package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.FornecedorDao;
import br.com.cotasmart.modelo.Fornecedor;

@Controller
public class FornecedorController {

	@RequestMapping("novoFornecedor")
	public String form() {
		return "fornecedor/adiciona";
	}

	@RequestMapping("adicionaFornecedor")
	public String adiciona(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();
		dao.adiciona(fornecedor);
		return "fornecedor/adiciona";
	}

	@RequestMapping("listaFornecedor")
	public String lista(Model model) {
		FornecedorDao dao = new FornecedorDao();
		model.addAttribute("fornecedores", dao.getLista());
		return "fornecedor/lista";

	}

	@RequestMapping("removeFornecedor")
	public String remove(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();
		dao.remove(fornecedor);
		return "redirect:listaFornecedor";
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
		return "fornecedor/mostra";
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
