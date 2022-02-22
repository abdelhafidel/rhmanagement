package com.upm.rh.controllers.ControllersADMIN;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoAdmin.AdminRepo;
import com.upm.rh.RepoForm.FormRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.user;

@Controller
public class AdminGestionEmp {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	ModelAndView mv = new ModelAndView();

	@Autowired
	private AdminRepo AdminRepo;

	@Autowired
	private UserRepo userRepo;
	

	// admin gestion emp
	@RequestMapping("/emp")
	public ModelAndView emp(Principal principal) {
		user admin = AdminRepo.findByUsername(principal.getName());
		List<user> users = userRepo.findByRole("USER");
		mv.addObject("admin", admin);
		mv.addObject("users", users);
		mv.setViewName("gemp");
		return mv;
	}
	

	
	// admin delete emp
	@RequestMapping("/admindelemp")
	public ModelAndView admindel(@RequestParam("id") int id) {
		
		userRepo.delete(id);
		mv.setViewName("redirect:/emp");
		return mv;
	}
	
	
	// modify personne
	@RequestMapping("/AdminModifyPr")
	public ModelAndView AdminModifyPr(@RequestParam("id") int id) {
		// ModelAndView mv = new ModelAndView();
		user user = userRepo.findOne(id);
		mv.addObject("user", user);
		mv.setViewName("AdminModifyPr");
		return mv;
	}
	

	// modify personne
	@RequestMapping("/AdminsaveModifyPr")
	public ModelAndView AdminsaveModifyPr(@RequestParam("id") int id, @ModelAttribute("user") user user) {
		user.setId(id);
		user.setPwd(encoder.encode(user.getPwd()));
		userRepo.save(user);
		mv.setViewName("redirect:/emp");
		return mv;
	}
}
