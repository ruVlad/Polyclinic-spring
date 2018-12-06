package com.dev.controller;

import java.util.List;

import com.dev.model.HealthSertificate;
import com.dev.service.HealthSertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/healthSertificate")
public class HealthSertificateController {

    @Autowired
    private HealthSertificateService healthSertificateService;

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addTeamPage() {
        ModelAndView modelAndView = new ModelAndView("add/addHealthSertificate");
        modelAndView.addObject("healthSertificate", new HealthSertificate());
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingTeam(@ModelAttribute HealthSertificate healthSertificate) {

        ModelAndView modelAndView = new ModelAndView("redirect:/healthSertificate/list");
        healthSertificateService.insert(healthSertificate);

        String message = "HealthSertificate was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/list")
    public ModelAndView listOfTeams() {
        ModelAndView modelAndView = new ModelAndView("list/listHealthSertificate");

        List<HealthSertificate> healthSertificates = healthSertificateService.getAll();
        modelAndView.addObject("healthSertificates", healthSertificates);

        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit/editHealthSertificate");
        HealthSertificate healthSertificate = healthSertificateService.getById(id);
        modelAndView.addObject("healthSertificate",healthSertificate);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingTeam(@ModelAttribute HealthSertificate healthSertificate, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/healthSertificate/list");

        healthSertificateService.update(healthSertificate);

        String message = "HealthSertificate was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/healthSertificate/list");
        healthSertificateService.delete(id);
        String message = "HealthSertificate was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
