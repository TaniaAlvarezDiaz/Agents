package dbManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dbManagement.GetAgent;
import dbManagement.model.Agent;
import dbManagement.repository.AgentRepository;

@Service
public class GetAgentImpl implements GetAgent {

	private AgentRepository repository;

	@Autowired
	public GetAgentImpl(AgentRepository repository) {
		this.repository = repository;
	}

	/**
	 * Método que devuelve el Participante buscado por email Hace uso del método
	 * findByEmail (mapeador)
	 */
	@Override
	public Agent getParticipant(String email) {

		return this.repository.findByEmail(email);
	}

}
