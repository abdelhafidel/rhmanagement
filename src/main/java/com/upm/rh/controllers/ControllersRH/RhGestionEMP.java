package com.upm.rh.controllers.ControllersRH;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoBull.bullRepo;
import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.user;

@Controller
public class RhGestionEMP {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	ModelAndView mv = new ModelAndView();

	@Autowired
	private RhRepo RhRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private bullRepo bullRepo;

	// gestion emp
	@RequestMapping("/rhgemp")
	public ModelAndView gesEMP(Principal principal) {
		user rhUser = RhRepo.findByUsername(principal.getName());
		List<user> users = userRepo.findByRole("USER");
		mv.addObject("users", users);
		mv.addObject("rh", rhUser);
		mv.setViewName("rhgemp");
		return mv;
	}

	// Ajoute nouveau personne
	@RequestMapping("/rhAjouterPr")
	public ModelAndView ajPr() {
		// ModelAndView mv = new ModelAndView();
		mv.setViewName("rhAjouterPr");
		return mv;
	}

	// save personne
	@RequestMapping(value = "/rhsavepr", method = RequestMethod.POST)
	public ModelAndView rhsave(@ModelAttribute("user") user user) {
		ModelAndView mv = new ModelAndView();
		String exist = userRepo.findCountUsername(user.getUsername());
		if (exist == null) {
			user.setPwd(encoder.encode(user.getPwd()));
			userRepo.save(user);
		}else {
			String msg = "Username Deja exist !!!";
			mv.addObject("msg", msg);
		}
		mv.setViewName("rhAjouterPr");
		return mv;
	}

	// supp personne
	@RequestMapping("/rhdel")
	public ModelAndView delper(@RequestParam("id") int id) {
		// ModelAndView mv = new ModelAndView();
		userRepo.delete(id);
		mv.setViewName("redirect:/rhgemp");
		return mv;
	}

	// modify personne
	@RequestMapping("/rhModifyPr")
	public ModelAndView modifyper(@RequestParam("id") int id) {
		// ModelAndView mv = new ModelAndView();
		user user = userRepo.findOne(id);
		mv.addObject("user", user);
		mv.setViewName("rhModifyPr");
		return mv;
	}

	// suite modify
	@RequestMapping("/saveModifyPr")
	public ModelAndView savemodifyper(@RequestParam("id") int id, @ModelAttribute("user") user user) {
		// ModelAndView mv = new ModelAndView();
		user.setId(id);
		user.setPwd(encoder.encode(user.getPwd()));
		userRepo.save(user);
		mv.setViewName("redirect:/rhgemp");
		return mv;
	}

}
