package agents.webService.responses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dbManagement.model.Agent;

@XmlRootElement(name = "agent")
public class RespuestaInfoREST {

	private Map<Integer, String> agents;
	private final static String AGENTSFILE = "src/main/resources/agents.csv";
	
	private String name;
	private String location;
	private String email;
	private String identificador;
	private String kind; //tipo de usuario
	private int kindCode; //codigo del tipo de usuario

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	@XmlElement
	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificador() {
		return identificador;
	}

	@XmlElement
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getKind() {
		return kind;
	}

	@XmlElement
	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getKindCode() {
		return kindCode;
	}

	@XmlElement
	public void setKindCode(int kindCode) {
		this.kindCode = kindCode;
	}

	/**
	 * Constructor
	 * @param agent
	 */
	public RespuestaInfoREST(Agent agent) {
		setName(agent.getNombre());
		setLocation(agent.getLocation().toString());
		setEmail(agent.getEmail());
		setIdentificador(agent.getIdentificador());
		setKind(agent.getTipo());
		setKindCode(obtenerCodigo(agent.getTipo()));
	}

	/**
	 * Método para obtener el codigo del tipo de agente
	 * que se pasa por parametro.
	 * Para ello leemos el fichero csv
	 * @param tipoAgente
	 * @return -1 si no hay codigo para el tipo de agente requerido
	 */ 
	public int obtenerCodigo(String tipoAgente) {
		//Cargamos el fichero
		loadAgents();
		//Recorremos el hasmap para saber el codigo del tipo del agente
		for (Map.Entry<Integer, String> entry : agents.entrySet()) {
			if (entry.getValue().equals(tipoAgente))
				return entry.getKey();
		}
		return -1;
	}
	
	/**
	 * Método para cargar los agentes del archivo csv
	 */
	private void loadAgents() {
		BufferedReader br = null;
		agents = new HashMap<Integer, String>();

		try {
			br = new BufferedReader(new FileReader(AGENTSFILE));
			while (br.ready()) {
				String[] linea = br.readLine().split(",");
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
}
