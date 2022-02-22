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
import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Bulletin;
import com.upm.rh.entity.user;

@Controller
public class RhGestionBulletin {

	ModelAndView mv = new ModelAndView();

	@Autowired
	private RhRepo RhRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private bullRepo bullRepo;
	
	// gestion bulletins
	@RequestMapping("/rhgbull")
	public ModelAndView gesbull(Principal principal) {
		user rhUser = RhRepo.findByUsername(principal.getName());
		List<Bulletin> bulletins = bullRepo.findAll();
		mv.addObject("rh", rhUser);
		mv.addObject("bull", bulletins);
		mv.setViewName("rhgbull");
		return mv;
	}

	// ajouter bulletin
	@RequestMapping("/rhaddbull")
	public ModelAndView addbull() {
		// ModelAndView mv = new ModelAndView();
		List<user> users = userRepo.findAll();
		List<Integer> idHad = userRepo.findIdHadBull();
		System.out.println(idHad);
		mv.addObject("idHad", idHad);
		mv.addObject("users", users);
		mv.setViewName("rhaddbull");
		return mv;
	}

	// save bulletin
	@RequestMapping("/rhsavebull")
	public ModelAndView savebull(@RequestParam("idemp") int id,@ModelAttribute("bulletin") Bulletin bulletin) {
		// ModelAndView mv = new ModelAndView();
		bulletin.setUser(userRepo.findOne(id));
		bullRepo.save(bulletin);
		mv.setViewName("redirect:/rhgbull");
		return mv;
	}

	
	//delete bulletin
	@RequestMapping("/rhdelbull")
	public ModelAndView delbull(@RequestParam("id") int id) {
		// ModelAndView mv = new ModelAndView();
	
		bullRepo.delete(id);
		mv.setViewName("redirect:/rhgbull");
		return mv;
	}
	
	//modify bull
	@RequestMapping("/rhmdfybull")
	public ModelAndView modbull(@RequestParam("id") int id) {
		Bulletin bulletin = bullRepo.findOne(id);
		List<user> users = userRepo.findAll();
		mv.addObject("users", users);
		mv.addObject("bull",bulletin);
		mv.setViewName("rhmdfybull");
		return mv;
	}
	
	

	//save update bull
	@RequestMapping("/updateBull")
	public ModelAndView saveUpdatebull(@RequestParam("idemp") int id,@ModelAttribute("bulletin") Bulletin bulletin) {
		bulletin.setUser(userRepo.findOne(id));
		bullRepo.save(bulletin);
		mv.setViewName("redirect:/rhgbull");
		return mv;
	}
	

}
