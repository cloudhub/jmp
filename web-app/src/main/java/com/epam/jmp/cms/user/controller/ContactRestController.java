package com.epam.jmp.cms.user.controller;

import com.epam.jmp.cms.user.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Aleksei_Okhrimenko on 20.05.2017.
 */
@RestController
public class ContactRestController {

    @Autowired
    ContactService service;

    @GetMapping("/getList")
    public List welcome() {
        return service.findAll();
    }
}
