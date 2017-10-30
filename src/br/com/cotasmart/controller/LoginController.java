package br.com.cotasmart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cotasmart.dao.UsuarioDao;
import br.com.cotasmart.modelo.Usuario;

@Transactional
@Controller
public class LoginController {

	@RequestMapping("login")
	public String login() {
		return "geral/login";
	}
	
	@RequestMapping("loginErro")
	public String loginErro(){
		return "geral/loginErro";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		UsuarioDao dao = new UsuarioDao();
		if (dao.existeUsuario(usuario)) {
			Usuario u = new Usuario();
			u = dao.alimentarUsuario(usuario);
			session.setAttribute("usuarioLogado", u);
			return "redirect:listaCotacoes";
		}else{
			
			return "redirect:loginErro";
		}
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}

}
