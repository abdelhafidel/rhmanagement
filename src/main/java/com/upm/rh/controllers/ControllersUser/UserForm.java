package com.upm.rh.controllers.ControllersUser;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.upm.rh.RepoDemandeForm.RepoDForm;
import com.upm.rh.RepoForm.FormRepo;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.DemandeFormation;
import com.upm.rh.entity.Formation;
import com.upm.rh.entity.user;

@Controller
public class UserForm {

	ModelAndView mv = new ModelAndView();

	@Autowired
	FormRepo formRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	RepoDForm repoDForm;
	
	// demande formation
	@RequestMapping("/usrdemandeform")
	public ModelAndView demandeconge(Principal principal) {

		user user = userRepo.findByUsername(principal.getName());
		List<Formation> listform = formRepo.findAll();
		List<Integer> empforms = repoDForm.IdFormEmp(user.getId());
		List<DemandeFormation> df = repoDForm.findAll();
		
		mv.addObject("df", df);
		mv.addObject("empforms", empforms);
		mv.addObject("iduser", user.getId());
		mv.addObject("listform", listform);
		mv.setViewName("usrdemandeform");
		return mv;
	}

	// demande formation
	@RequestMapping("/usrsaveform")
	public ModelAndView usrsaveform(@RequestParam("idform") int idform, @RequestParam("idemp") int idemp) {

		DemandeFormation DF = new DemandeFormation();
		DF.setIdemploye(idemp);
		DF.setIdformation(idform);
		DF.setDatedemande(new Date());
		repoDForm.save(DF);

		List<Integer> empforms = repoDForm.IdFormEmp(idemp);

		mv.addObject("empforms", empforms);
		mv.setViewName("redirect:/usrdemandeform");
		return mv;
	}

}
