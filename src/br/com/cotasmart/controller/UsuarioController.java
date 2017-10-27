package br.com.cotasmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.UsuarioDao;
import br.com.cotasmart.modelo.Usuario;
@Transactional
@Controller
public class UsuarioController {

	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/adiciona";
	}

	@RequestMapping("adicionaUsuario")
	public String adiciona(Usuario usuario) {
		if (usuario != null) {
			UsuarioDao dao = new UsuarioDao();
			if(dao.adiciona(usuario)){
				return "redirect:listaUsuario";	
			}else{
				return "RESOLVER FUTURAMENTE";
			}
		}
		System.out.println("deu ruim");
		return "www.google.com.br";
	}

	@RequestMapping("listaUsuario")
	public String lista(Model model) {
		UsuarioDao dao = new UsuarioDao();
		model.addAttribute("usuarios", dao.getLista());
		return "usuario/lista";

	}

	@RequestMapping("mostraUsuario")
	public String mostra(Long codUsuario, Model model) {
		UsuarioDao dao = new UsuarioDao();
		model.addAttribute("usuario", dao.buscaPorId(codUsuario));
		return "usuario/mostra";
	}

	@RequestMapping("atualizarUsuario")
	public String atualiza(Usuario usuario) {
		UsuarioDao dao = new UsuarioDao();
		dao.altera(usuario);
		return "redirect:listaUsuario";

	}

	@RequestMapping("desativarUsuario")
	public String desativaUsuario(Usuario usuario) {
		UsuarioDao dao = new UsuarioDao();
		dao.desativarUsuario(usuario.getCodUsuario());
		return "redirect:listaUsuario";
	}

	@RequestMapping("ativarUsuario")
	public String ativaUsuario(Usuario usuario) {
		UsuarioDao dao = new UsuarioDao();
		dao.ativarUsuario(usuario.getCodUsuario());
		return "redirect:listaUsuario";
	}

}
