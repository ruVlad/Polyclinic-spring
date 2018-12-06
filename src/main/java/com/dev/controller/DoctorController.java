package com.dev.controller;

import java.util.List;

import com.dev.model.Doctor;
import com.dev.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add/addDoctor");
		modelAndView.addObject("doctor", new Doctor());
		return modelAndView;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Doctor doctor) {

		ModelAndView modelAndView = new ModelAndView("redirect:/doctor/list");
		doctorService.insert(doctor);

		String message = "Doctor was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value="/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list/listDoctor");

		List<Doctor> doctors = doctorService.getAll();
		modelAndView.addObject("doctors", doctors);

		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit/editDoctor");
		Doctor doctor = doctorService.getById(id);
		modelAndView.addObject("doctor",doctor);
		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Doctor doctor, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("redirect:/doctor/list");

		doctorService.update(doctor);

		String message = "Doctor was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/doctor/list");
		doctorService.delete(id);
		String message = "Doctor was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
