package br.com.cotasmart.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.CidadeDao;

@Transactional
@Controller
public class CidadeController {

	@RequestMapping("alimentarCidades")
	public void alimentarCidades(Model model){
		CidadeDao dao = new CidadeDao();
		System.out.println("chamou controller cidade");
		model.addAttribute("cidades", dao.getListaCidades());
	}
	
}
