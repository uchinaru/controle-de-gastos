package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import models.itens;
import models.saldo;
import utils.dateUtils;
import utils.excelUtils;
import utils.formatUtils;

public class classTeste {

	public static void main(String[] args) throws ParseException {
		double somaDeGastos = 0d;
		double resultado = 0d;

		saldo saldo = new saldo(5000, dateUtils.formatarData("25/01/2023"), "Jonatas F Benicio");

		List<itens> itens = new ArrayList<>();
		itens.add(new itens("Conta De Luz", 90, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("Fies", 193, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("Internet Movel Claro", 50, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("Internet FIX", 100, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("IPVA Carro", 126, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("Dentista", 60, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("Cartao De Credito", 0, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("Compra Do Mes", 0, dateUtils.formatarData("25/01/2023")));
		itens.add(new itens("Gastos Atoa", 0, dateUtils.formatarData("25/01/2023")));

		for (itens itens2 : itens) {
			System.out.println(
					"Item: " + itens2.getNome() + " Valor: " + formatUtils.formataValores(itens2.getValorDeCusto()));
			somaDeGastos += itens2.getValorDeCusto();
		}

		resultado = saldo.getSaldo() - somaDeGastos;

		System.out.println("\n------------------------------------------");
		System.out.println("Saldo inicial: " + formatUtils.formataValores(saldo.getSaldo()));
		System.out.println("Gastos: " + formatUtils.formataValores(somaDeGastos));
		System.out.println("Saldo atualizado: " + formatUtils.formataValores(resultado));

		try {
			excelUtils.gerarExcelListaGastos(itens, saldo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
