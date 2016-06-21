package com.gabrielamorim.service;

import org.springframework.data.annotation.Id;

public class Pessoa {

	@Id
	private String id;

	private String nome;

	private EnumSexo sexo;

	private Integer idade;

	private String cpf;

	private String rg;

	private String telefone;

	private String endereco;

	private String cidade;

	private String estado;

	private String celular;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public enum EnumSexo {
		MASCULINO("M"), FEMININO("F");

		private String sigla;

		EnumSexo(String sigla) {
			this.sigla = sigla;
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sexo=" + sexo
				+ ", idade=" + idade + ", cpf=" + cpf + ", rg=" + rg
				+ ", telefone=" + telefone + ", endereco=" + endereco
				+ ", cidade=" + cidade + ", estado=" + estado + ", celular="
				+ celular + "]";
	}

}
