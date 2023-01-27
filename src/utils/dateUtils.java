package utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dateUtils {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdfh = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	public static Date formatarData(String data) {
		DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataFormatada = LocalDate.parse(data, DTF);

		return Date.valueOf(dataFormatada);
	};

}
