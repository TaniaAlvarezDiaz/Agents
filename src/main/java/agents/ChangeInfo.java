package agents;

import org.springframework.http.ResponseEntity;

import agents.webService.request.PeticionChangeEmailREST;
import agents.webService.request.PeticionChangePasswordREST;
import agents.webService.responses.RespuestaChangeInfoREST;

public interface ChangeInfo {
	/**
	 * Cambio de contraseña
	 *
	 * @param datos requeridos (username, password, newPassword)
	 * @return
	 */
	public ResponseEntity<RespuestaChangeInfoREST> changePassword(PeticionChangePasswordREST datos);

	/**
	 * Cambio de email
	 * 
	 * @param datos requeridos (username, password, newEmail)
	 * @return respuesta en xml o json
	 */
	public ResponseEntity<RespuestaChangeInfoREST> changeEmail(PeticionChangeEmailREST datos);
}
