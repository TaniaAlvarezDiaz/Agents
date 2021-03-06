package dbManagement;

import dbManagement.model.Agent;

public interface UpdateInfo {
	/**
	 * Permite la solicitud de cambio de contraseña
	 */
	public void updatePassword(Agent agent, String password, String newPassword);

	public void updateEmail(Agent agent, String email);
}
