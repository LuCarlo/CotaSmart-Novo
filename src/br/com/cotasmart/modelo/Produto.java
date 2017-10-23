package br.com.cotasmart.modelo;

public class Produto {
	private int codProduto;
	private String nome;
	private String codBarras;
	private boolean ativo;
	private Long codGrupoProdutos;

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getCodGrupoProdutos() {
		return codGrupoProdutos;
	}

	public void setCodGrupoProdutos(Long codGrupoProdutos) {
		this.codGrupoProdutos = codGrupoProdutos;
	}

}
