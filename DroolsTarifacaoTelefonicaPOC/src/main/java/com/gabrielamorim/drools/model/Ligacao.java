package com.gabrielamorim.drools.model;

import java.util.Date;

public class Ligacao {

	private Usuario origem;
	private Usuario destino;
	private Date inicio;
	private Integer duracao;
	private Double preco;

	public Ligacao(Usuario origem, Usuario destino, Date inicio, Integer duracao) {
		this(origem, destino, inicio, duracao, null);
	}

	public Ligacao(Usuario origem, Usuario destino, Date inicio,
			Integer duracao, Double preco) {
		this.origem = origem;
		this.destino = destino;
		this.inicio = inicio;
		this.duracao = duracao;
		this.preco = preco;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Usuario getOrigem() {
		return origem;
	}

	public void setOrigem(Usuario origin) {
		this.origem = origin;
	}

	public Usuario getDestino() {
		return destino;
	}

	public void setDestino(Usuario destination) {
		this.destino = destination;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date start) {
		this.inicio = start;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPreco() {
		return preco;
	}
}
