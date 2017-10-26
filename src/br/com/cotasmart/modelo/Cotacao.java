package br.com.cotasmart.modelo;

import java.util.Date;

public class Cotacao {
	private int codCotacao;

	public int getIdCotacao() {
		return codCotacao;
	}

	public void setIdCotacao(int codCotacao) {
		this.codCotacao = codCotacao;
	}

	private Date data;
	private int codUsuario;
	private boolean ativo;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
