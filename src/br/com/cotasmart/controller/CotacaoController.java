package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cotasmart.dao.CotacaoDao;


@Transactional
@Controller
public class CotacaoController {

	@RequestMapping("listaCotacoes")
	public String listaCotacoes(Model model){
		CotacaoDao dao = new CotacaoDao();
		model.addAttribute("cotacoes", dao.getLista());
		
		return "cotacao/lista";
	}
	
	
}
