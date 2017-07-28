package br.com.cotasmart.modelo;

public class Produto {
	int codProduto;
	String nome;
	String codBarras;
	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	Long codStatus;
	Long codGrupoProdutos;

	public Produto(String nome, Long codStatus, Long codGrupoProdutos) {
		this.nome = nome;
		this.codStatus = codStatus;
		this.codGrupoProdutos = codGrupoProdutos;
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

	public Long getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(Long codStatus) {
		this.codStatus = codStatus;
	}

	public Long getCodGrupoProdutos() {
		return codGrupoProdutos;
	}

	public void setCodGrupoProdutos(Long codGrupoProdutos) {
		this.codGrupoProdutos = codGrupoProdutos;
	}

}
