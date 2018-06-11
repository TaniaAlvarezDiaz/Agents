package agents.factory;

import agents.webService.responses.errors.ErrorResponse;
import agents.webService.responses.errors.IncorrectPasswordErrorResponse;
import agents.webService.responses.errors.PasswordDoNotMatchErrorResponse;
import agents.webService.responses.errors.RequiredKindErrorResponse;
import agents.webService.responses.errors.RequiredUsernameErrorResponse;
import agents.webService.responses.errors.RequiredPasswordErrorResponse;
import agents.webService.responses.errors.SameEmailErrorResponse;
import agents.webService.responses.errors.UnknownErrorResponse;
import agents.webService.responses.errors.UserNotFoundResponse;
import agents.webService.responses.errors.WrongEmailStyleErrorResponse;

/**
 * Creacion de los distintos tipos de error.
 * @author Tania Álvarez Díaz
 *
 */
public class ErrorFactory {

	public static enum Errors {
		INCORRECT_PASSWORD, REQUIRED_USERNAME, REQUIRED_PASSWORD, REQUIRED_KIND, USER_NOT_FOUND, WRONG_EMAIL_STYLE, INCORRECT_PASSWORD_DO_NOT_MATCH, SAME_EMAIL
	}

	// Generar Constructor privado no queremos que se pueda tener varias
	// instancias de la clase.
	private ErrorFactory() {
	}

	public static ErrorResponse getError(Errors error) {
		switch (error) {
		case INCORRECT_PASSWORD:
			return new IncorrectPasswordErrorResponse();
		case REQUIRED_USERNAME:
			return new RequiredUsernameErrorResponse();
		case REQUIRED_PASSWORD:
			return new RequiredPasswordErrorResponse();
		case REQUIRED_KIND:
			return new RequiredKindErrorResponse();
		case USER_NOT_FOUND:
			return new UserNotFoundResponse();
		case WRONG_EMAIL_STYLE:
			return new WrongEmailStyleErrorResponse();
		case INCORRECT_PASSWORD_DO_NOT_MATCH:
			return new PasswordDoNotMatchErrorResponse();
		case SAME_EMAIL:
			return new SameEmailErrorResponse();
		default:// en caso de no conocer el error.
			return new UnknownErrorResponse();
		}
	}

}
