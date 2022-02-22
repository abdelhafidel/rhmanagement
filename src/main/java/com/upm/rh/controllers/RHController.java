package com.upm.rh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.upm.rh.RepoBull.bullRepo;
import com.upm.rh.RepoDemandeForm.RepoDForm;
import com.upm.rh.RepoForm.FormRepo;
import com.upm.rh.RepoRH.RhRepo;
import com.upm.rh.RepoSalaire.RepoSalaire;
import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.Bulletin;
import com.upm.rh.entity.ChartArea;
import com.upm.rh.entity.DemandeFormation;
import com.upm.rh.entity.Formation;
import com.upm.rh.entity.user;

@Controller
public class RHController {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	ModelAndView mv = new ModelAndView();

	@Autowired
	private RhRepo RhRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private bullRepo bullRepo;

	@Autowired
	private RepoDForm repoDForm;

	@Autowired
	private FormRepo formrepo;

	@Autowired
	private RepoSalaire repoSalaire;

	// RH home
	@RequestMapping("/rh")
	public ModelAndView rhHome(Principal principal) {
		 ModelAndView mv = new ModelAndView();
		user rh = RhRepo.findByUsername(principal.getName());
		long sumsal = repoSalaire.sumSalaire();
		long totaluser = userRepo.count();
		float sumHT = bullRepo.SumHT();
		float sumHB = bullRepo.SumHB();

		System.out.println(sumHB);

		Long SumTauxTrav = (long) ((sumHT / (130 * totaluser)) * 100);

		Long SumTauxBns = (long) ((sumHB / (40 * totaluser)) * 100);

		mv.addObject("SumTauxBns", SumTauxBns);
		mv.addObject("SumTauxTrav", SumTauxTrav);
		mv.addObject("rh", rh);
		mv.addObject("totaluser", totaluser);
		mv.addObject("sumsal", sumsal);
		mv.setViewName("rh");
		return mv;

	}

	// chart Area
	@RequestMapping("/chartline")
	public void chartLine(HttpServletResponse res) throws IOException {
		JsonObject jsonObject2 = new JsonObject();

		List<String> formNames = formrepo.findFormationNames();
		List<BigInteger> subs = formrepo.findSubs();

		if (subs.size() < formNames.size()) {
			for (int i = 0; i < 100; i++) {
				subs.add(BigInteger.valueOf(0));
			}
		}

		JsonArray jsonF = new JsonArray();
		JsonArray jsonS = new JsonArray();

		int j = 0;
		while (j < formNames.size()) {

			jsonF.add(formNames.get(j));
			jsonS.add(subs.get(j));
			j++;
		}

		jsonObject2.add("form2", jsonF);
		jsonObject2.add("subs", jsonS);

		res.setContentType("text/html");
		PrintWriter pwriter2 = res.getWriter();

		pwriter2.println(jsonObject2.toString());

		pwriter2.close();

	}

	// chart pie
	@RequestMapping("/chartpie")
	public void chartPie(HttpServletResponse res) throws IOException {
		JsonObject jsonObject = new JsonObject();

		List<BigInteger> userN = userRepo.findNumberEmp();
		List<String> userR = userRepo.findRoleEmp();

		JsonArray jsonN = new JsonArray();
		JsonArray jsonR = new JsonArray();

		int j = 0;
		while (j < userN.size()) {

			jsonN.add(userN.get(j));
			jsonR.add(userR.get(j));
			j++;
		}

		jsonObject.add("userN", jsonN);
		jsonObject.add("userR", jsonR);

		res.setContentType("text/html");
		PrintWriter pwriter = res.getWriter();

		pwriter.println(jsonObject.toString());

		pwriter.close();

	}

	// RH profile
	@RequestMapping("/rhprofile")
	public ModelAndView rhProfile(Principal principal) {
		
		user rh = RhRepo.findByUsername(principal.getName());
		mv.addObject("rh", rh);
		mv.setViewName("rhprofile");
		return mv;
	}

	// update profile
	@RequestMapping(value = "/updateRH", method = RequestMethod.POST)
	public ModelAndView updateRH(Principal principal, @ModelAttribute("user") user user) {

		ModelAndView mv = new ModelAndView();

		user rh = RhRepo.findByUsername(principal.getName());
		try {

			String loginExist = userRepo.findCountUsername(user.getUsername());
			if (loginExist == null || loginExist.equals(principal.getName())) {

				user.setId(RhRepo.findByUsername(principal.getName()).getId());
				user.setPwd(encoder.encode(user.getPwd()));

				RhRepo.save(user);

			} else if (loginExist != null && !loginExist.equals(principal.getName())) {
				String msg = "Username Deja exist !!!";
				mv.addObject("msg", msg);
			}

		} catch (Exception e) {
			System.out.println("login is null ms that's fine");
		}

		mv.addObject("rh", rh);
		mv.setViewName("rhprofile");
		return mv;
	}

}
