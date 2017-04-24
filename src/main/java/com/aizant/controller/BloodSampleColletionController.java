package com.aizant.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.aizant.DAO.BloodSampleCollectionDAO;
import com.aizant.Services.IBloodSampleService;
import com.aizant.model.BloodSampleCollection;
import com.aizant.model.StudyVolunteer;
import com.aizant.model.User;
import com.google.gson.Gson;

@Controller
public class BloodSampleColletionController {
	/*
	 * ------------------------------------- DAO declaration
	 * --------------------------------------
	 */
	
	
	@Autowired
	private BloodSampleCollectionDAO bloodSampleColletionDao;
	@Autowired
	private IBloodSampleService bloodSampleService;
	SessionFactory sessionFactory;

	
	
	/*
	 * ------------------------------------- Update User
	 * --------------------------------------
	 */
	@RequestMapping(value = "edit_BloodSampleCollection", method = RequestMethod.GET)
	public ModelAndView editBloodSample(@RequestParam int id,
			@ModelAttribute("BloodSampleCollection") BloodSampleCollection bloodSampleCollection) {
		BloodSampleCollection u1 = bloodSampleColletionDao.get(id);
		return new ModelAndView("edit_BloodSampleCollection", "bloodSampleCollection", u1);
	}
	
	@RequestMapping(value = "/update_BloodSampleColletion", method = RequestMethod.POST)
	public ModelAndView updateBloodSampleColletion(HttpServletRequest request,@RequestParam String id,@ModelAttribute("BloodSampleColletion") BloodSampleCollection bloodSampleColletion) {
		System.out.println(bloodSampleColletion.getId());
	
	
		bloodSampleColletionDao.saveOrUpdate(bloodSampleColletion);
		StudyVolunteer sv=new StudyVolunteer();
		System.out.println(sv.getId());
	System.out.println(bloodSampleColletion.getRegisterNumber());
		return new ModelAndView("redirect:/view_studyVolunteer?id="+bloodSampleColletion.getRegisterNumber());
	}
	/*
	 * ------------------------------------- Store User
	 * --------------------------------------
	 */

	@RequestMapping(value="/store_BloodSampleCollection", method=RequestMethod.POST)
	public ModelAndView store(@Valid @ModelAttribute("BloodSampleCollection") BloodSampleCollection bloodSampleCollection, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("hi");

			return new ModelAndView("redirect:/dispaly_study");
		}
	

	
		bloodSampleColletionDao.saveOrUpdate(bloodSampleCollection);
		return new ModelAndView("redirect:/add_BloodSampleCollection");
	}
	
	/*
	 * ------------------------------------- List User(retrieving)
	 * --------------------------------------
	 */
	@Transactional
	@RequestMapping(value = "/list4", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showList2(@ModelAttribute BloodSampleCollection bloodSampleCollection) {
		List<BloodSampleCollection> list=bloodSampleColletionDao.list();

		System.out.println("List of Blood Sample"+list);
		Gson u = new Gson();
		String json = u.toJson(list);
		return json;
	}

	/*
	 * ------------------------------------- Add User
	 * --------------------------------------
	 */
	@RequestMapping("/add_BloodSampleCollection")
	public ModelAndView display4() {
		ModelAndView m4 = new ModelAndView("add_BloodSampleCollection");
		return m4;
	}
	@RequestMapping("/display_BloodSampleCollection")
	public ModelAndView display() {
		ModelAndView m4 = new ModelAndView("display_BloodSampleCollection");
		return m4;
	}

	@ModelAttribute("BloodSampleCollection")
	public BloodSampleCollection createProduct() {
		return new BloodSampleCollection();
	}


	

		/*
	 * ------------------------------------- View User
	 * --------------------------------------
	 */
	@RequestMapping(value = "view_BloodSampleColletion", method = RequestMethod.GET)
	public ModelAndView viewBloodSampleColletion(@RequestParam int id, @ModelAttribute BloodSampleCollection bloodSampleColletion) {
		System.out.println(id);
		System.out.println(bloodSampleColletion.getId());
		BloodSampleCollection SampleColletion = bloodSampleColletionDao.get(id);
		return new ModelAndView("view_user", "bloodSampleColletion", SampleColletion);
		// return new ModelAndView("viewproduct");
	}

	/*
	 * ------------------------------------- Delete User
	 * --------------------------------------
	 */
	@RequestMapping(value = "/deleteBloodSampleCollecion", method = RequestMethod.POST)
	public @ResponseBody String delete(@RequestParam int BloodSampleColletionId) {
		System.out.println("hello " + BloodSampleColletionId);

		//bloodSampleColletionDao.delete(BloodSampleColletionId);
		bloodSampleService.deleteFromStudyVolunteer(BloodSampleColletionId);
		Gson u = new Gson();
		String json = u.toJson(BloodSampleColletionId);
		return json;
	}

	

}
