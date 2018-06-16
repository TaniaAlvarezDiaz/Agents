package agents.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import agents.factory.ErrorFactory;
import agents.factory.ErrorFactory.Errors;
import dbManagement.model.Agent;

public class Assert {
	
	private static Map<Integer, String> agents;
	private final static String AGENTSFILE = "src/main/resources/agents.csv";

	public static boolean isUsernameEmpty(String username) {
		if (username.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_USERNAME);
		else
			return false;
	}

	public static boolean isPasswordEmpty(String password) {
		if (password.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_PASSWORD);
		else
			return false;
	}
	
	public static boolean isKindEmpty(String kind) {
		if (kind.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_KIND);
		else
			return false;
	}
	
	/**
	 * Método para comprobar si el kind introducido existe y es correcto
	 * @param kind
	 * @return
	 */
	public static boolean isKindValid(String kind, Agent agent) {
		//Cargamos el fichero
		loadAgents();
		if (!agents.containsValue(kind))
			return false;
		else {
			if (agent.getTipo().equals(kind))
				return true;
			throw ErrorFactory.getError(Errors.INCORRECT_KIND);
		}
	}
	
	/**
	 * Método para cargar los agentes del archivo csv
	 */
	private static void loadAgents() {
		BufferedReader br = null;
		agents = new HashMap<Integer, String>();

		try {
			br = new BufferedReader(new FileReader(AGENTSFILE));
			while (br.ready()) {
				String[] linea = br.readLine().split(";");
				Integer key = Integer.parseInt(linea[0]);
				String value = linea[1];
				agents.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}

	/**
	 * Comprobacion de si el correo es valido
	 * 
	 * @param email
	 * @return true si es valido.
	 */
	public static boolean isEmailValid(String email) {
		String[] mailSplit = email.split("@");
		if (mailSplit.length != 2) {
			throw ErrorFactory.getError(Errors.WRONG_EMAIL_STYLE);
		}
		mailSplit = email.split("\\.");
		if (mailSplit.length != 2 || mailSplit[0].length() == 0 || mailSplit[1].length() == 0) {
			throw ErrorFactory.getError(Errors.WRONG_EMAIL_STYLE);
		}
		return true;
	}

	/**
	 * 
	 * @param participant
	 * @return devuelve false si no es null o excepcion
	 */
	public static boolean isParticipantNull(Agent participant) {
		if (participant == null) {
			throw ErrorFactory.getError(Errors.USER_NOT_FOUND);
		}
		return false;
	}

	public static boolean isPasswordCorrect(String password, Agent participant) {
		if (!password.equals(participant.getPassword())) {
			throw ErrorFactory.getError(Errors.INCORRECT_PASSWORD_DO_NOT_MATCH);
		}
		return true;
	}

	public static boolean isSamePassword(String password, String password2) {
		if (password.equals(password2)) {
			throw ErrorFactory.getError(Errors.INCORRECT_PASSWORD);
		}
		return true;
	}

	public static boolean isSameEmail(String email, String email2) {
		if (email.equals(email2)) {
			throw ErrorFactory.getError(Errors.SAME_EMAIL);
		}
		return true;
	}
}
