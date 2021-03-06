package dbManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dbManagement.UpdateInfo;
import dbManagement.model.Agent;
import dbManagement.repository.AgentRepository;

@Service
public class UpdateInfoImpl implements UpdateInfo {

	private AgentRepository repository;

	@Autowired
	public UpdateInfoImpl(AgentRepository repository) {
		this.repository = repository;
	}

	/**
	 * Método que permite la actualización de la contraseña del agente. Se
	 * comprueba que las contraseñas no estén vacías, sean distintas y la actual
	 * coincida con la del agente
	 */
	@Override
	public void updatePassword(Agent participant, String password, String newPassword) {

		if (password != null && newPassword != null && !(password.equals(newPassword))
				&& participant.getPassword().equals(password)) {
			participant.setPassword(newPassword);
			this.repository.save(participant);
		}

	}

	/**
	 * Método que permite la actualización del email del agente.
	 */
	@Override
	public void updateEmail(Agent participant, String email) {
		if (email != null) {
			participant.setEmail(email);
			this.repository.save(participant);
		}
	}

}
