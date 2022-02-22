package com.upm.rh.controllers.ControllersRH;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoBull.bullRepo;
import com.upm.rh.RepoDemandeForm.RepoDForm;
import com.upm.rh.RepoForm.FormRepo;
import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.DemandeFormation;
import com.upm.rh.entity.Formation;
import com.upm.rh.entity.user;

@Controller
public class RHGestionFormation {

	ModelAndView mv = new ModelAndView();

	@Autowired
	private RhRepo RhRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private bullRepo bullRepo;
	
	@Autowired
	private FormRepo formRepo;
	
	@Autowired
	private RepoDForm repoDForm;

	
	// gestion list formation
	@RequestMapping("/ajForm")
	public ModelAndView ajform(Principal principal) {
		user rhUser = RhRepo.findByUsername(principal.getName());
		List<Formation> listform = formRepo.findAll();
		mv.addObject("listform", listform);
		mv.addObject("rh", rhUser);
		mv.setViewName("rhAjForm");
		return mv;
	}
	
	// ajouter formation
	@RequestMapping("/addForm")
	public ModelAndView addform() {
		mv.setViewName("rhaddform");
		return mv;
	}
	

	
	// save formation
	@RequestMapping("/rhsaveform")
	public ModelAndView saveform(@ModelAttribute("formation") Formation formation) {
		formRepo.save(formation);
		mv.setViewName("redirect:/ajForm");
		return mv;
	}
	
	// mod form
	@RequestMapping("/rhmodform")
	public ModelAndView modform(@RequestParam("id") int id) {
		Formation formation = formRepo.findOne(id);
		mv.addObject("formation", formation);
		mv.setViewName("rhmodform");
		return mv;
	}
	
	// save mod formation
	@RequestMapping("/saveform")
	public ModelAndView savemodform(@ModelAttribute("formation") Formation formation) {
		formRepo.save(formation);
		mv.setViewName("redirect:/ajForm");
		return mv;
	}

	// delete formation
	@RequestMapping("/rhdelform")
	public ModelAndView dellform(@RequestParam("id") int id) {
		formRepo.delete(id);
		mv.setViewName("redirect:/ajForm");
		return mv;
	}
	
	
	
}
