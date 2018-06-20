package agents.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReaderCSV {

	private Map<Integer, String> agents = new HashMap<Integer, String>();
	private final static String AGENTSFILE = "src/main/resources/agents.csv";

	public Map<Integer, String> getAgents() {
		return agents;
	}

	/**
	 * Constructor
	 */
	public ReaderCSV() {
		loadAgents();
	}

	/**
	 * Método para cargar los agentes del archivo csv
	 */
	private void loadAgents() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(AGENTSFILE));
			while (br.ready()) {
				String[] linea = br.readLine().split(";");
				Integer key = Integer.parseInt(linea[0]);
				String value = linea[1];
				agents.put(key, value);
			}
		} catch (IOException e) {
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
	 * Método que devuelve el codigo del tipo de agente que se pasa por parametro
	 * 
	 * @param kind
	 *            tipo de agente
	 * @return -1 si el tipo de agente no existe
	 */
	public int getKindCode(String kind) {
		if (agents.containsValue(kind)) {
			for (Map.Entry<Integer, String> entry : agents.entrySet()) {
				if (entry.getValue().equals(kind))
					return entry.getKey();
			}
		}
		return -1;
	}

	/**
	 * Método que devuelve todos los tipos disponibles
	 * 
	 * @return
	 */
	public Set<String> getKinds() {
		Set<String> res = new HashSet<String>();
		for (String s : agents.values())
			res.add(s);
		return res;
	}
}
