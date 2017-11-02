package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.EmpresaDao;
import br.com.cotasmart.modelo.Empresa;

@Transactional
@Controller
public class EmpresaController {
	
	@RequestMapping("mostrarMinhaEmpresa")
	public String mostrarEmpresa(Model model){
		EmpresaDao dao = new EmpresaDao();
		model.addAttribute("empresa", dao.getLista());
		return "empresa/mostra";
	}
	@RequestMapping("atualizaMinhaEmpresa")
	public String atualizaMinhaEmpresa(Empresa empresa){
		EmpresaDao dao = new EmpresaDao();
		dao.atualiza(empresa);
		return "redirect:listaCotacoes";
	}
	

}
