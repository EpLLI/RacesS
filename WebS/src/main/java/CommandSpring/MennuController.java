package CommandSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MennuController {
	@RequestMapping(value = "/NewIndex", method = RequestMethod.GET)
	public String mainMenu() {
		return "view/menu";
	}
	@RequestMapping(value = "/adminLoginForm", method = RequestMethod.GET)
	public String displayAdminLoginForm() {
		return "view/adminLogin";
	}
	@RequestMapping(value = "/userLoginForm", method = RequestMethod.GET)
	public String displayUserLoginForm() {
		return "view/userLogin";
	}
	@RequestMapping(value = "/bucmekLoginForm", method = RequestMethod.GET)
	public String displayBucmekLoginForm() {
		return "view/bucmekLogin";
	}

	
}
