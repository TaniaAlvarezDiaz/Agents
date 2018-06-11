package dbManagement;

import dbManagement.model.Agent;

public interface GetAgent {
	/**
	 * Permite la solicitud la de información para el usuario.
	 */
	public Agent getParticipant(String email);
	
}
