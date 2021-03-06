package br.com.cotasmart.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		String uri = request.getRequestURI();
		if (uri.endsWith("login") || (uri.endsWith("efetuaLogin")) || (uri.contains("resources"))
				|| (uri.endsWith("loginErro")) || (uri.endsWith("informarValorProdutos"))) {
			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("login");
		return false;

	}

}
