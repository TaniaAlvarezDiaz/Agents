package dbManagement;

import dbManagement.model.Agent;

public interface GetAgent {
	
	public Agent findByEmail(String email);
	
	public Agent findByIdentificador(String identificador);
}
