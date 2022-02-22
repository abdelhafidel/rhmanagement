package com.upm.rh.controllers.ControllersUser;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoABS.AbsRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Absences;
import com.upm.rh.entity.user;

@Controller
public class UserGAbs {

	ModelAndView mv = new ModelAndView();

	@Autowired
	UserRepo userRepo;

	@Autowired
	AbsRepo absRepo;


	// demande abs
	@RequestMapping("/usergabs")
	public ModelAndView demandeconge(Principal principal){
		
		user user = userRepo.findByUsername(principal.getName());
		
		List<Absences> absences = absRepo.findAbs(user.getId());
		mv.addObject("user", user);
		mv.addObject("absences", absences);
		mv.setViewName("userGabs");
		return mv;
	}
	
	// ajouter abs
	@RequestMapping("/userajabs")
	public ModelAndView usrajconge(@ModelAttribute("absences") Absences absences,@RequestParam("iduser") int id) {
		
		absences.setUser(userRepo.findOne(id));
		absRepo.save(absences);
		
		mv.setViewName("redirect:/usergabs");
		return mv;
	}

	// delete abs
	@RequestMapping("/usrdelabs")
	public ModelAndView usrdelabs(@RequestParam("id") int id) {

		absRepo.delete(id);
		mv.setViewName("redirect:/usergabs");
		return mv;
	}

}
