package br.com.cotasmart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.CotacaoDao;
import br.com.cotasmart.dao.ProdutoDao;
import br.com.cotasmart.modelo.Produto;
import br.com.cotasmart.modelo.Usuario;

@Transactional
@Controller
public class CotacaoController {

	@RequestMapping("listaCotacoes")
	public String listaCotacoes(Model model, HttpSession session) {
		CotacaoDao dao = new CotacaoDao();
		Usuario usuario = new Usuario();
		usuario = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("cotacoes", dao.getLista(usuario));
		return "cotacao/lista";
	}

	@RequestMapping("novaCotacao")
	public String form(Model model) {
		CotacaoDao dao = new CotacaoDao();
		ProdutoDao produto = new ProdutoDao();

		model.addAttribute("produtos", produto.getLista());
		model.addAttribute("cotacao", dao.adicionaCotacao());
		return "cotacao/novo";
	}

	@RequestMapping("adicionaProduto")
	public String adicionaProduto(Produto produto, int codCotacao, int quantidade) {
		CotacaoDao dao = new CotacaoDao();
		dao.adicionaProduto(produto, codCotacao, quantidade);
		return "redirect:novaCotacao";
	}

}
