package models;

import java.util.Date;
import java.util.Objects;

public class itens {

	private String nome;
	private double valorDeCusto;
	private Date data;

	public itens() {
		super();
	}

	public itens(String nome, double valorDeCusto, Date data) {
		super();
		this.nome = nome;
		this.valorDeCusto = valorDeCusto;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorDeCusto() {
		return valorDeCusto;
	}

	public void setValorDeCusto(double valorDeCusto) {
		this.valorDeCusto = valorDeCusto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, valorDeCusto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itens other = (itens) obj;
		return Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(valorDeCusto) == Double.doubleToLongBits(other.valorDeCusto);
	}

}
