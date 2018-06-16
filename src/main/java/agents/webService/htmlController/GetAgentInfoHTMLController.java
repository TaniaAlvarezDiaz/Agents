package agents.webService.htmlController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import agents.util.Assert;
import agents.webService.responses.errors.ErrorResponse;
import dbManagement.GetAgent;
import dbManagement.model.Agent;

@Controller
public class GetAgentInfoHTMLController {

	@Autowired
	private GetAgent getParticipant;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicalicerLogin(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLogin(HttpSession session, @RequestParam String username, @RequestParam String password, @RequestParam String kind,
			Model model) {

		Assert.isUsernameEmpty(username);
		Assert.isPasswordEmpty(password);
		Assert.isKindEmpty(kind);

		Agent participant = getParticipant.findByIdentificador(username);

		Assert.isParticipantNull(participant);
		Assert.isPasswordCorrect(password, participant);
		Assert.isKindValid(kind, participant);

		session.setAttribute("agent", participant);

		return "datosAgent";
	}

	@ExceptionHandler(ErrorResponse.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponseNotFound(ErrorResponse excep, Model model) {
		model.addAttribute("error", excep.getMessageStringFormat());

		return "error";
	}
}
