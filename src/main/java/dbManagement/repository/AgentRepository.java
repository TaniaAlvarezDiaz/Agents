package dbManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dbManagement.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

	/**
	 * Método que devuelve el agente el cual es buscado por email en la base
	 * de datos
	 * 
	 * @param email del agente
	 * @return El agente con dicho email
	 */
	public Agent findByEmail(String email);
	
	/**
	 * Busca el agente por identificador
	 * @param identificador
	 * @return
	 */
	public Agent findByIdentificador(String identificador);

}
