package com.upm.rh.controllers.ControllersUser;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoABS.AbsRepo;
import com.upm.rh.RepoSalaire.RepoSalaire;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Absences;
import com.upm.rh.entity.Salaire;
import com.upm.rh.entity.user;

@Controller
public class UserSal {
	
	ModelAndView mv = new ModelAndView();

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RepoSalaire repoSalaire;


	// salaire
	@RequestMapping("/usrVPaym")
	public ModelAndView usrVsal(Principal principal){
		
		user user= userRepo.findByUsername(principal.getName()); 
		
		try {
			Salaire salaire = repoSalaire.findOne(user.getSalaire().getIdSalaire());
			mv.addObject("salaire", salaire);
			
		} catch (NullPointerException e) {
			System.out.println("AJOUTER UN PAIEMENT POUR CHAQUE USER !!!!" +e);
		}
		
		
		
		
		mv.setViewName("usrVPaym");
		return mv;
	}

}
