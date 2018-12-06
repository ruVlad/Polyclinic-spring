package com.dev.controller;

import java.util.List;

import com.dev.model.Patient;
import com.dev.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addTeamPage() {
        ModelAndView modelAndView = new ModelAndView("add/addPatient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingTeam(@ModelAttribute Patient patient) {

        ModelAndView modelAndView = new ModelAndView("redirect:/patient/list");
        patientService.insert(patient);

        String message = "Patient was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/list")
    public ModelAndView listOfTeams() {
        ModelAndView modelAndView = new ModelAndView("list/listPatient");

        List<Patient> patients = patientService.getAll();
        modelAndView.addObject("patients", patients);

        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit/editPatient");
        Patient patient = patientService.getById(id);
        modelAndView.addObject("patient",patient);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingTeam(@ModelAttribute Patient patient, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/patient/list");

        patientService.update(patient);

        String message = "Patient was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/patient/list");
        patientService.delete(id);
        String message = "Patient was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
