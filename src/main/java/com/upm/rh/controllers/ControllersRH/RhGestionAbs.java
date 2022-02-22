package com.upm.rh.controllers.ControllersRH;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoABS.AbsRepo;
import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Absences;
import com.upm.rh.entity.user;

@Controller
public class RhGestionAbs {
	
	ModelAndView mv = new ModelAndView();

	@Autowired
	UserRepo userRepo;

	@Autowired
	AbsRepo absRepo;
	@Autowired
	private RhRepo RhRepo;
	
	// set abs
		@RequestMapping("/rhgabs")
		public ModelAndView gesAbs(Principal principal) {
			
			user rhUser = RhRepo.findByUsername(principal.getName());
			List<Absences> absences = absRepo.findAll();

			mv.addObject("absences", absences);
			mv.addObject("rh", rhUser);
			mv.setViewName("rhgabs");
			return mv;
		}
		
		
		// set abs
		@RequestMapping("/delABS")
		public ModelAndView desAbs(@Param("id") int id) {
			
			absRepo.delete(id);

			mv.setViewName("redirect:/rhgabs");
			return mv;
		}
	
	
}
