package agents;

import org.springframework.http.ResponseEntity;

import agents.webService.request.PeticionInfoREST;
import agents.webService.responses.RespuestaInfoREST;

public interface GetAgentInfo {

	public ResponseEntity<RespuestaInfoREST> getPOSTpetition(PeticionInfoREST peticion);

}
