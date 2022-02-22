package com.upm.rh.controllers.ControllersADMIN;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoAdmin.AdminRepo;
import com.upm.rh.RepoForm.FormRepo;
import com.upm.rh.entity.Formation;
import com.upm.rh.entity.user;

@Controller
public class AdminGestionFormation {

	ModelAndView mv = new ModelAndView();

	@Autowired
	private AdminRepo AdminRepo;

	@Autowired
	private FormRepo formrepo;


	// list des formations admin
	@RequestMapping("/formations")
	public ModelAndView formations(Principal principal) {
		user admin = AdminRepo.findByUsername(principal.getName());
		List<Formation> listform = formrepo.findAll();
		mv.addObject("admin", admin);
		mv.addObject("listform", listform);
		mv.setViewName("formations");
		return mv;
	}
	
	
	// admin delete fromation
	@RequestMapping("/admindelform")
	public ModelAndView admindelform(@RequestParam("id") int id) {
		formrepo.delete(id);
		mv.setViewName("redirect:/formations");
		return mv;
	}

}
