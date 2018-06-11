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

	@Override
	public Agent findByEmail(String email) {
		return this.repository.findByEmail(email);
	}

	@Override
	public Agent findByIdentificador(String identificador) {
		return this.repository.findByIdentificador(identificador);
	}

}
