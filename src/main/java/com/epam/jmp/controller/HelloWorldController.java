package com.epam.jmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alexei.okhrimenko on 07.02.2017.
 */

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "OK");
        return "index";
    }

    @RequestMapping(path = "contact/{name}", method = RequestMethod.GET)
    public String contact(@PathVariable String name, ModelMap model) {
        model.addAttribute("name", name);
        return "contact";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public ModelAndView submitForm(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("email") String email) {
        ModelAndView model = new ModelAndView("contact");
        model.addObject("msg", "submitted details: " + firstName + ", " + lastName);
        return model;
    }

    @RequestMapping(value = "example", method = RequestMethod.GET)
    public String printHtml() {
        return "redirect:/resources/html/example.html";
    }
}
