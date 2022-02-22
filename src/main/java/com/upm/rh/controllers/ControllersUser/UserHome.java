package com.upm.rh.controllers.ControllersUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.upm.rh.RepoBull.bullRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.user;

@Controller
public class UserHome {

	ModelAndView mv = new ModelAndView();

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	bullRepo bullRepo;

	// home d'admin
	@RequestMapping("/usr")
	public ModelAndView index(Principal principal) {
		user user = userRepo.findByUsername(principal.getName());
		
		mv.addObject("user", user);
		mv.setViewName("userhome");
		return mv;
	}
	
	// chart pie
		@RequestMapping("/chart3")
		@ResponseBody
		public String chartPie(Principal principal) throws IOException {
			JsonObject jsonObject = new JsonObject();
			
			user user = userRepo.findByUsername(principal.getName());
			
			int HT = bullRepo.HT(user.getId());
			

			JsonArray jsonN = new JsonArray();
		

			
				jsonN.add(HT);
				jsonN.add(130-HT);

			jsonObject.add("userHT", jsonN);
			
			return jsonObject.toString();

		}


	// home d'admin
	@RequestMapping("/usrprofil")
	public ModelAndView usrprofil(Principal principal) {

		user user = userRepo.findByUsername(principal.getName());
		mv.addObject("user", user);
		mv.setViewName("usrprofil");
		return mv;
	}
	
	
	//save profile
	@RequestMapping("/saveusrprofil")
	public ModelAndView saveprofil(@ModelAttribute("user") user user) {
		
		userRepo.save(user);
		mv.setViewName("redirect:/usr");
		return mv;
	}
}
