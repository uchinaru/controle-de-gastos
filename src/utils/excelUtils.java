package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import models.itens;
import models.saldo;

public class excelUtils {

	private static final String fileName = "E:/eclipse-workspace/gastos-mensais.xls";

	public static void gerarExcelListaGastos(List<itens> itens, saldo saldo) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Gastos Mensais");
		Cell cell = null;
		Row row = null;
		double somaGasto = 0d;
		int countRow = itens.size() != 0 ? itens.size() + 3 : 0;

		if (itens.size() != 0) {
			row = sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue("Usuario: " + saldo.getNomeUsuario() + " - Salario: "
					+ formatUtils.formataValores(saldo.getSaldo()) + " - Data registro: " + saldo.getDataRecebimento());
			CellRangeAddress region = new CellRangeAddress(0, 0, 0, 3); // Mergeando as colunas
			sheet.addMergedRegion(region); // Mergeando as colunas
			
			// Cria as celulas para os titulos
			row = sheet.createRow(2); // linha 3 contendo os titulos
			cell = row.createCell(0);
			cell.setCellValue("Descricao");
			cell = row.createCell(1);
			cell.setCellValue("Valor");
			cell = row.createCell(2);
			cell.setCellValue("Data pagamento");
			for (int i = 0; i < itens.size(); i++) {
				itens it = itens.get(i);

				row = sheet.createRow(i + 3);
				cell = row.createCell(0);
				cell.setCellValue(it.getNome());

				cell = row.createCell(1);
				cell.setCellValue(it.getValorDeCusto());

				cell = row.createCell(2);
				cell.setCellValue(it.getData());

				somaGasto += it.getValorDeCusto();
			}
			row = sheet.createRow(countRow);
			cell = row.createCell(0);
			cell.setCellValue("Gastos totais:");
			cell = row.createCell(1);
			cell.setCellValue(somaGasto);
			// Define a largura das colunas
			sheet.setColumnWidth(0, 256 * 30); // define a largura da coluna 0 como 20 unidades de largura de célula
			sheet.setColumnWidth(1, 256 * 10);
			sheet.setColumnWidth(2, 256 * 15);
			try {
				FileOutputStream out = new FileOutputStream(new File(excelUtils.fileName));
				workbook.write(out);
				out.close();
				workbook.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		} else {
			workbook.close();
			System.out.println("lista vazia");
			return;
		}

	}
}
