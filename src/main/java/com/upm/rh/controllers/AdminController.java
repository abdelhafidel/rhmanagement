package com.upm.rh.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoAdmin.AdminRepo;
import com.upm.rh.RepoBull.bullRepo;
import com.upm.rh.RepoForm.FormRepo;
import com.upm.rh.RepoSalaire.RepoSalaire;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.user;

@Controller
public class AdminController {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	ModelAndView mv = new ModelAndView();

	@Autowired
	private AdminRepo AdminRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private bullRepo bullRepo;

	@Autowired
	private FormRepo formrepo;

	@Autowired
	private RepoSalaire repoSalaire;
	
	
	// profile admin
	@RequestMapping("/profile")
	public ModelAndView profile(Principal principal) {
		ModelAndView mv = new ModelAndView();
		user admin = AdminRepo.findByUsername(principal.getName());
		mv.addObject("admin", admin);
		mv.setViewName("tables");
		return mv;
	}
	

	// home d'admin
	@RequestMapping("/index")
	public ModelAndView index(Principal principal){
		user admin = AdminRepo.findByUsername(principal.getName());

		long sumsal = repoSalaire.sumSalaire();
		long totaluser = userRepo.count();
		float sumHT = bullRepo.SumHT();
		float sumHB = bullRepo.SumHB();

		System.out.println(sumHB);

		Long SumTauxTrav = (long) ((sumHT / (130 * totaluser)) * 100);

		Long SumTauxBns = (long) ((sumHB / (40 * totaluser)) * 100);

		mv.addObject("SumTauxBns", SumTauxBns);
		mv.addObject("SumTauxTrav", SumTauxTrav);
		mv.addObject("totaluser", totaluser);
		mv.addObject("sumsal", sumsal);
		mv.addObject("admin", admin);
		mv.setViewName("index");
		return mv;
	}

	// home for all user
	@RequestMapping("/")
	public ModelAndView home() {
		// ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	// login page for all user
	@RequestMapping("/login")
	public ModelAndView login() {
		// ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}



	// logout pour tout les user
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}

	// update profile
	@RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
	public ModelAndView updateAdmin(Principal principal, @ModelAttribute("user") user user) {
		ModelAndView mv = new ModelAndView();
		
		user admin = AdminRepo.findByUsername(principal.getName());
		
		try {

			String loginExist = userRepo.findCountUsername(user.getUsername());
			if (loginExist == null || loginExist.equals(principal.getName())) {

				user.setId(AdminRepo.findByUsername(principal.getName()).getId());

				user.setPwd(encoder.encode(user.getPwd()));

				AdminRepo.save(user);

			} else if (loginExist != null && !loginExist.equals(principal.getName())) {
				String msg = "Username Deja exist !!!";
				mv.addObject("msg", msg);
			}

		} catch (Exception e) {
			System.out.println("login is null ms that's fine");
		}
		

		mv.addObject("admin", admin);
		mv.setViewName("redirect:/profile");
		return mv;
	}

}
