package com.upm.rh.controllers.ControllersUser;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoConge.CongeRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Conge;
import com.upm.rh.entity.user;

@Controller
public class UserConge {

	ModelAndView mv = new ModelAndView();

	@Autowired
	UserRepo userRepo;

	@Autowired
	CongeRepo congeRepo;

	// demande conge
	@RequestMapping("/demandeconge")
	public ModelAndView demandeconge(Principal principal) {
		user user = userRepo.findByUsername(principal.getName());

		List<Conge> conges = congeRepo.findconge(user.getId());
		mv.addObject("user", user);
		mv.addObject("conges", conges);
		mv.setViewName("demandeconge");
		return mv;
	}

	// ajouter conge
	@RequestMapping("/usrajconge")
	public ModelAndView usrajconge(@ModelAttribute("conge") Conge conge, Principal principal) {
		user user = userRepo.findByUsername(principal.getName());
		List<user> users = new ArrayList<>();
		users.add(user);
		conge.setUsers(users);
		congeRepo.save(conge);
		mv.setViewName("redirect:/demandeconge");
		return mv;
	}

	// delete conge
	@RequestMapping("/usrdelconge")
	public ModelAndView usrdelconge(@RequestParam("id") int id) {

		congeRepo.delete(id);
		mv.setViewName("redirect:/demandeconge");
		return mv;
	}

}
