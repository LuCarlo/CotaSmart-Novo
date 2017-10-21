package br.com.cotasmart.modelo;

public class Usuario {
	private Long codUsuario;
	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

	private String nome;
	private String login;
	private String senha;
	private boolean ativo;
	private Integer codGrupo;
	
//	public Usuario(String nome, String login, String senha, Integer codStatus, Integer codGrupo) {
//		super();
//		this.nome = nome;
//		this.login = login;
//		this.senha = senha;
//		this.codStatus = codStatus;
//		this.codGrupo = codGrupo;
//	}

	public Long getCodUsuario() {
		return codUsuario;
	}

	public String getNome() {
		return nome;
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

	public Integer getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(Integer codGrupo) {
		this.codGrupo = codGrupo;
	}

}
