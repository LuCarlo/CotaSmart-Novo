package br.com.cotasmart.modelo;

import java.util.Date;

public class Cotacao {
	private int codCotacao;
	private Date data;
	private int codUsuario;
	private boolean ativo;
	private Date dataFinalizacao;
	private boolean finalizado;
	private float valorTotal;

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getCodCotacao() {
		return codCotacao;
	}

	public void setCodCotacao(int codCotacao) {
		this.codCotacao = codCotacao;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public int getIdCotacao() {
		return codCotacao;
	}

	public void setIdCotacao(int codCotacao) {
		this.codCotacao = codCotacao;
	}

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
