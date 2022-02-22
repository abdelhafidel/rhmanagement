package com.upm.rh.controllers.ControllersRH;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoDemandeForm.RepoDForm;
import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.entity.DemandeFormation;
import com.upm.rh.entity.user;

@Controller
public class RHGestionDemandeForm {

	ModelAndView mv = new ModelAndView();
	@Autowired
	private RhRepo RhRepo;
	@Autowired
	private RepoDForm repoDForm;

	// gestion formation
	@RequestMapping("/rhgform")
	public ModelAndView gesForm(Principal principal) {
		user rhUser = RhRepo.findByUsername(principal.getName());
		List<DemandeFormation> DF = repoDForm.findAll();
		mv.addObject("DF", DF);
		mv.addObject("rh", rhUser);
		mv.setViewName("rhgform");
		return mv;
	}

	// modefy formation
	@RequestMapping("/rhmdyd")
	public ModelAndView gesForm(@RequestParam("iddemande") int id, @RequestParam("etatdemande") String etat,
			@RequestParam("raisonrefus") String refus) {
		DemandeFormation df = repoDForm.findOne(id);
		df.setEtatdemande(etat);
		df.setRaisonrefus(refus);
		repoDForm.save(df);
		mv.setViewName("redirect:/rhgform");
		return mv;
	}

}
