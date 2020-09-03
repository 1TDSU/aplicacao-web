package br.com.fiap.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private Date dataNasc;
	private char genero;
	private String telefone;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String sobrenome, Date dataNasc, char genero, String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.genero = genero;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	//M�todo sobrecarregado para o parse da Data!
	public void setDataNasc(String dataNasc) {
		SimpleDateFormat sf = new SimpleDateFormat();
		try {
			this.dataNasc = sf.parse(dataNasc);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}