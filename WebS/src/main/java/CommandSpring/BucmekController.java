package CommandSpring;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Race;
import by.academy.it.pojos.Tupebets;
import by.academy.it.service.IAdminService;
import by.academy.it.service.IBucmekService;

@Controller
public class BucmekController {
	private static Logger log = Logger.getLogger(BucmekController.class);
	@Autowired
	private IBucmekService bucmekService;
	@Autowired
	private IAdminService adminService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String mainMenu() {
		return "view/menu";
	}
	@RequestMapping(value = "/BucmekMenu", method = { RequestMethod.GET })
	public String AdminMenu(ModelMap model) {
		displayRace(model);
		displayTupebets(model);
		displayCoefficient(model);
		return "BucmekPages/BucmekMenu";
	}
	private void displayTupebets(ModelMap model) {
		List<Tupebets> tupe = null;
		tupe = bucmekService.getAllTupeBets();
		model.put("tupebets", tupe);


	}
	private void displayCoefficient(ModelMap model) {
		List<Coefficient> coef= null;
		coef = bucmekService.getAllCoefficiet();
		model.put("coef", coef);


	}
	@RequestMapping(value = "/BucmekPages/{page}", method = { RequestMethod.POST,RequestMethod.GET })
	public String execute(ModelMap model, @PathVariable Integer page) {
		int pageB = 1;
		int recordsPerPage = 5;

		if (page != null)
			pageB = page;

		List<Race> race = adminService.get((pageB - 1) * recordsPerPage, recordsPerPage);

		long noOfRecords = adminService.count();

		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", pageB);

		model.put("race", race);
		displayTupebets(model);
		displayCoefficient(model);
		
		return "BucmekPages/BucmekMenu";
	}
	private void displayRace(ModelMap model) {
		int pageB = 1;
		int recordsPerPage = 5;

		List<Race> race = adminService.get((pageB - 1) * recordsPerPage, recordsPerPage);

		long noOfRecords = adminService.count();

		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", pageB);

		model.put("race", race);


	}
	@RequestMapping(value = "/UpdateCoefficient", method = RequestMethod.POST)
	public String UpdateRace(@ModelAttribute("coefficient") Coefficient coef, ModelMap model) {
		String page = null;
		
		bucmekService.addCoefficient(coef);; 
		displayRace(model);
		displayTupebets(model);
		displayCoefficient(model);
		return "BucmekPages/BucmekMenu";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		//return "Logout";
		return "redirect:/login"		;
	}
}
