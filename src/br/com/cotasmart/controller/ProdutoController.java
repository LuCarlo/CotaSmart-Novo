package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.ProdutoDao;
import br.com.cotasmart.modelo.Produto;
@Transactional
@Controller
public class ProdutoController {

	@RequestMapping("listaProduto")
	public String lista(Model model) {
		ProdutoDao dao = new ProdutoDao();
		model.addAttribute("produtos", dao.getLista());

		return "produto/lista";

	}

	@RequestMapping("novoProduto")
	public String adiciona(Produto produto) {
		if (produto != null) {
			ProdutoDao dao = new ProdutoDao();
			dao.adiciona(produto);
			return "redirect:listaProduto";
		} else {
			System.out.println("Produto vazio no controller");
		}
		return "redirect:listaProduto";

	}

	@RequestMapping("alteraProduto")
	public String altera(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.altera(produto);
		return "redirect:listaProduto";
	}

	@RequestMapping("desativaProduto")
	public String desativa(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.desativaProduto(produto.getCodProduto());
		return "redirect:listaProduto";

	}
	@RequestMapping("ativaProduto")
	public String ativa(Produto produto){
		ProdutoDao dao = new ProdutoDao();
		dao.ativaProduto(produto.getCodProduto());
		
		return "redirect:listaProduto";
		
	}
}
