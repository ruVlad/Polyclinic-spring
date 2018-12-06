package com.dev.controller;

import java.util.List;

import com.dev.model.Salary;
import com.dev.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addTeamPage() {
        ModelAndView modelAndView = new ModelAndView("add/addSalary");
        modelAndView.addObject("salary", new Salary());
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingTeam(@ModelAttribute Salary salary) {

        ModelAndView modelAndView = new ModelAndView("redirect:/salary/list");
        salaryService.insert(salary);

        String message = "Salary was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/list")
    public ModelAndView listOfTeams() {
        ModelAndView modelAndView = new ModelAndView("list/listSalary");

        List<Salary> salaries = salaryService.getAll();
        modelAndView.addObject("salaries", salaries);

        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit/editSalary");
        Salary salary = salaryService.getById(id);
        modelAndView.addObject("salary",salary);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingTeam(@ModelAttribute Salary salary, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/salary/list");

        salaryService.update(salary);

        String message = "Salary was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/salary/list");
        salaryService.delete(id);
        String message = "Salary was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
