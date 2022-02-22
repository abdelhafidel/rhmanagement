package com.upm.rh.controllers.ControllersRH;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoConge.CongeRepo;
import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Conge;
import com.upm.rh.entity.user;

@Controller
public class RHGestionConge {

	ModelAndView mv = new ModelAndView();
	@Autowired
	private RhRepo RhRepo;
	@Autowired
	UserRepo userRepo;

	@Autowired
	CongeRepo congeRepo;

	// gestion conges
	@RequestMapping("/rhgcng")
	public ModelAndView gesCng(Principal principal) {
		user rhUser = RhRepo.findByUsername(principal.getName());
		List<Conge> conges = congeRepo.findAll();

		mv.addObject("conges", conges);
		mv.addObject("rh", rhUser);
		mv.setViewName("rhgcng");
		return mv;
	}

	// save conges
	@RequestMapping("/saveconge")
	public ModelAndView saveCng(@RequestParam("idconge") int id, @RequestParam("ETATDEMANDE") String etat,
			@RequestParam("refus") String refus) {
		Conge conge = congeRepo.getOne(id);
			conge.setRefus(refus);
			conge.setETATDEMANDE(etat);
			congeRepo.save(conge);
		mv.setViewName("redirect:/rhgcng");
		return mv;
	}

}
