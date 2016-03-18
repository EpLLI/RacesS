package CommandSpring;

import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.academy.it.pojos.Race;
import by.academy.it.service.IAdminService;
import by.academy.it.serviceException.ServiceException;

@Controller
public class AdminController {
	private static Logger log = Logger.getLogger(AdminController.class);
	@Autowired
	private IAdminService adminService;

	@RequestMapping(value = "/AdminMenu", method = { RequestMethod.GET })
	public String AdminMenu(ModelMap model) throws ServiceException {
		try{
			displayRace(model);
		} catch (ServiceException e) {
			log.error(e);
		}
		return "adminPages/adminMenu";
	}

	@RequestMapping(value = "/AdminPages/{page}", method = { RequestMethod.POST, RequestMethod.GET })
	public String execute(ModelMap model, @PathVariable Integer page) throws ServiceException {
		int pageB = 1;
		int recordsPerPage = 5;
		try{
		if (page != null)
			pageB = page;

		List<Race> race = adminService.get((pageB - 1) * recordsPerPage, recordsPerPage);

		long noOfRecords = adminService.count();

		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", pageB);

		model.put("race", race);
		} catch (ServiceException e) {
			log.error(e);
		}
		return "adminRacePage";
	}

	private void displayRace(ModelMap model) throws ServiceException {
		int pageB = 1;
		int recordsPerPage = 5;
		try{
		List<Race> race = adminService.get((pageB - 1) * recordsPerPage, recordsPerPage);

		long noOfRecords = adminService.count();

		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", pageB);

		model.put("race", race);
		} catch (ServiceException e) {
			log.error(e);
		}

	}

	@RequestMapping(value = "/addRace", method = RequestMethod.POST)
	public String addRace(HttpSession session, ModelMap model, @ModelAttribute("race") @Valid Race raced,
			BindingResult br) throws ServiceException{
		String page = null;
		try {
		if (!br.hasErrors()) {

			adminService.addRaceCoef(raced);
		}
		displayRace(model);
		} catch (ServiceException e) {
			log.error(e);
		}
		return page = "adminRacePage";
	}

	@RequestMapping(value = "/UpdateResultRace", method = RequestMethod.POST)
	public String UpdateRace(@ModelAttribute("race") Race race, ModelMap model) throws ServiceException {
		String page = null;
try{
		adminService.updateRace(race);
		displayRace(model);
	} catch (ServiceException e) {
		log.error(e);
	}
		return page = "adminRacePage";
	}

}
