package com.epam.jmp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alexei.okhrimenko on 07.02.2017.
 */

@Controller
@RequestMapping("/welcome")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "OK");
        return "index";
    }
}
