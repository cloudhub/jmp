package com.epam.jmp.cms.user.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Aleksei_Okhrimenko on 20.05.2017.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {

        ModelAndView modelAndView = new ModelAndView("exception");
        modelAndView.addObject("name", e.getClass().getSimpleName());
        modelAndView.addObject("message", e.getMessage());

        return modelAndView;
    }
}
