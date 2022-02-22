package com.upm.rh.controllers.ControllersRH;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.RepoSalaire.RepoSalaire;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Salaire;
import com.upm.rh.entity.user;

@Controller
public class RHGestionPaiement {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RepoSalaire repoSalaire;

	@Autowired
	private RhRepo RhRepo;

	// gestion payment
	@RequestMapping("/rhgpym")
	public ModelAndView gespym(Principal principal) {
		ModelAndView mv = new ModelAndView();
		user rhUser = RhRepo.findByUsername(principal.getName());

		List<Salaire> salaires = repoSalaire.findAll();
		List<user> users = userRepo.findAll();
		
		mv.addObject("rh", rhUser);
		mv.addObject("users", users);
		mv.addObject("salaires", salaires);
		mv.setViewName("rhgpym");
		return mv;
	}

	// Ajouter payment
	@RequestMapping("/savePaiement")
	public ModelAndView savepy(@ModelAttribute("salaire") Salaire salaire, @RequestParam("idemp") int idemp) {
		ModelAndView mv = new ModelAndView();

		user user = userRepo.findOne(idemp);

		salaire.setUser(user);

		repoSalaire.save(salaire);

		mv.setViewName("redirect:/rhgpym");
		return mv;
	}

	// delete payment
	@RequestMapping("/delSal")
	public ModelAndView delsal(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();

		repoSalaire.delete(id);

		mv.setViewName("redirect:/rhgpym");
		return mv;
	}

}
