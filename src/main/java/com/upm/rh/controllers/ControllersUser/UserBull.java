package com.upm.rh.controllers.ControllersUser;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoBull.bullRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Bulletin;
import com.upm.rh.entity.user;


@Controller
public class UserBull {
	ModelAndView mv = new ModelAndView();
	
	@Autowired
	bullRepo bullRepo;
	
	@Autowired
	UserRepo userRepo;

	// gestion Bull
	@RequestMapping("/usrgbull")
	public ModelAndView usrbul(Principal principal) {
		user user = userRepo.findByUsername(principal.getName());
		Bulletin bulletin = bullRepo.findUserBull(user.getId());
		mv.addObject("bu", bulletin);
		mv.setViewName("usrgbull");
		return mv;
	}
	
	// save bull
	@RequestMapping("/usrsavebull")
	public ModelAndView savebull(Principal principal,@RequestParam("travail") int tra,@RequestParam("benus") int bn) {
		user user = userRepo.findByUsername(principal.getName());
		Bulletin bulletin = bullRepo.findUserBull(user.getId());
		if(tra>0)
		bulletin.addNbHeurs(tra);
		if(bn>0)
		bulletin.addNbHeursBenus(bn);
		if(bn>0 || tra>0)
		bullRepo.save(bulletin);
		mv.setViewName("redirect:/usrgbull");
		return mv;
	}

}
