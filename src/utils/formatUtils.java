package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class formatUtils {

	public static Locale getLocaleBR() {
		return new Locale("pt", "BR");
	}

	public static String formataValores(double valor) {
		NumberFormat format = NumberFormat.getCurrencyInstance(getLocaleBR());

		return format.format(valor);
	}

}
