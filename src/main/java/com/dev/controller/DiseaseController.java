package com.dev.controller;

import java.util.List;

import com.dev.model.Disease;
import com.dev.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addTeamPage() {
        ModelAndView modelAndView = new ModelAndView("add/addDisease");
        modelAndView.addObject("disease", new Disease());
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingTeam(@ModelAttribute Disease disease) {

        ModelAndView modelAndView = new ModelAndView("redirect:/disease/list");
        diseaseService.insert(disease);

        String message = "Disease was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/list")
    public ModelAndView listOfTDiseases() {
        ModelAndView modelAndView = new ModelAndView("list/listDisease");

        List<Disease> diseases = diseaseService.getAll();
        modelAndView.addObject("diseases", diseases);

        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit/editDisease");
        Disease disease = diseaseService.getById(id);
        modelAndView.addObject("disease",disease);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingTeam(@ModelAttribute Disease disease, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/disease/list");

        diseaseService.update(disease);

        String message = "Disease was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/disease/list");
        diseaseService.delete(id);
        String message = "Disease was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
