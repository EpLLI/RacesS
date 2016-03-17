package CommandSpring;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.academy.it.pojos.Race;
import by.academy.it.service.IAdminService;
import by.academy.it.service.ServiceException;


@Controller
public class AdminController {
	private static Logger log = Logger.getLogger(AdminController.class);
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "/AdminMenu", method = { RequestMethod.GET })
	public String AdminMenu(ModelMap model) {
		displayRace(model);
		return "adminPages/adminMenu";
	}
	
	@RequestMapping(value = "/AdminPages/{page}", method = { RequestMethod.POST,RequestMethod.GET })
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
		
		return "adminRacePage";
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
	@RequestMapping(value = "/addRace", method = RequestMethod.POST)
	public String addRace(HttpSession session, ModelMap model,@ModelAttribute("race") @Valid Race raced,BindingResult br) {
		String page = null;
		
		
		if (!br.hasErrors()) {
			

			try {
				adminService.addRaceCoef(raced);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		displayRace(model);
		return page = "adminRacePage";
	}
	
	
	@RequestMapping(value = "/UpdateResultRace", method = RequestMethod.POST)
	public String UpdateRace(@ModelAttribute("race") Race race, ModelMap model) {
		String page = null;
		
		try {
			adminService.updateRace(race);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		displayRace(model);
		return page = "adminRacePage";
	}
	
		
}
