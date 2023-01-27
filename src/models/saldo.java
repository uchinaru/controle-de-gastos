package models;

import java.sql.Date;

public class saldo {

	private String nomeUsuario;
	private double saldo;
	private Date dataRecebimento;

	public saldo(double salario, Date data, String nomeUsuario) {
		super();
		this.saldo = salario;
		this.dataRecebimento = data;
		this.nomeUsuario = nomeUsuario;
	}

	public saldo() {
		super();
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsiario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
}
