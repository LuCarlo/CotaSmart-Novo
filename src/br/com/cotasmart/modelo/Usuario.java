package br.com.cotasmart.modelo;

public class Usuario {
	private Long codUsuario;
	private String nome;
	private String login;
	private String senha;
	private boolean ativo;
	private boolean administrador;

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

	

	public Long getCodUsuario() {
		return codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
