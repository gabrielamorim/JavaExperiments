package com.gabrielamorim.drools.model;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
	
	private String operadora;
	private String plano;
	private String nome;
	private List<Ligacao> ligacoes;
	
	public Usuario(String name, String operadora, String plano) {
		this.nome = name;
		this.operadora = operadora;
		this.plano = plano;
		this.ligacoes = new ArrayList<Ligacao>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ligacao> getLigacoes() {
		return ligacoes;
	}
	
	public void setLigacoes(List<Ligacao> calls) {
		this.ligacoes = calls;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getPlano() {
		return plano;
	}
}
