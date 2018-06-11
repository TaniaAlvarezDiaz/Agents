package agents.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase creada para realizar funciones que no tienen relacion con la logica de
 * los controladores
 * 
 * @author Tania Álvarez Díaz
 *
 */
public class Utilidades {

	public static int getEdad(Date fechaNacimiento) {
		Calendar calendarioNacimiento = Calendar.getInstance();
		calendarioNacimiento.setTime(fechaNacimiento);
		int dianacimiento = calendarioNacimiento.get(Calendar.DAY_OF_YEAR);

		Calendar calendariohoy = Calendar.getInstance();
		int diaHoy = calendariohoy.get(Calendar.DAY_OF_YEAR);
		if (dianacimiento - diaHoy == 0) {// Si la resta de días que llevamos de
											// año es 0, significa que hemos
											// cumplido años
			return calendariohoy.get(Calendar.YEAR) - calendarioNacimiento.get(Calendar.YEAR);

		} else {

			return calendariohoy.get(Calendar.YEAR) - calendarioNacimiento.get(Calendar.YEAR) - 1;

		}

	}

}
