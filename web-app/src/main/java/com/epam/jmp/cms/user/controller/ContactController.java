package com.epam.jmp.cms.user.controller;

import com.epam.jmp.cms.admin.Admin;
import com.epam.jmp.cms.user.model.Contact;
import com.epam.jmp.cms.user.model.Description;
import com.epam.jmp.cms.user.service.ContactService;
import com.epam.jmp.cms.utils.ContactDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexei.okhrimenko on 07.02.2017.
 */

@Controller
@SessionAttributes("contact")
@RequestMapping("/")
public class ContactController {

    private static final Logger LOGGER = Logger.getLogger(ContactController.class);

    @Autowired
    ContactService service;

    /*TODO refactoring*/
    @Autowired
    private ContactDAO contactDAO;

    /*TODO refactoring*/
    @Autowired
    private Admin admin;

    /**
     * Get all contacts
     *
     * @param model all contacts from XML file
     * @return renders all contacts on the page
     */
    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("contacts", service.findAll());
        return "contacts";
    }

    @RequestMapping(value = "createContact", method = RequestMethod.POST)
    public ModelAndView createContact(@ModelAttribute Contact contact) {
        service.create(contact);
        return new ModelAndView("redirect:/contacts");
    }

    @RequestMapping(value = "editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contact = service.findById(id);
        ModelAndView model = new ModelAndView("editcontact");
        model.addObject("contact", contact);
        return model;
    }

    @RequestMapping(value = "deleteContact", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        return new ModelAndView("redirect:/contacts");
    }

    @RequestMapping(value = "addContactForm", method = RequestMethod.GET)
    public ModelAndView addContactForm() {
        return new ModelAndView("addcontact","command",new Contact());
    }

    @RequestMapping(value = "editContactForm", method = RequestMethod.POST)
    public ModelAndView editContactForm(@ModelAttribute Contact contact) {
        service.update(contact);
        return new ModelAndView("redirect:/contacts");
    }

    /*TODO refactoring*/
    @RequestMapping(value = "description", method = RequestMethod.POST)
    public ResponseEntity<Description> updateDescription(@RequestBody Description description){
        if (description != null) {
            description.setPoints(description.getPoints() + 20);
        }
        return new ResponseEntity<Description>(description, HttpStatus.OK);
    }

    /*TODO refactoring*/
    @RequestMapping(value = "summary", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> summary(@RequestHeader(value="User-Agent", defaultValue="foo") String userAgent,
                                 @CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
                                 HttpServletResponse response) throws IOException {
        hitCounter++;
        if (hitCounter>5) {
            throw new IOException("this is io exception");
        }
        Cookie cookie = new Cookie("hitCounter", hitCounter.toString());
        response.addCookie(cookie);
        return service.findAll();
    }

    /*TODO refactoring*/
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "OK");
        return "index";
    }

    /*TODO refactoring*/
    @RequestMapping(path = "delete/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable String id) {
        contactDAO.deleteContact(id);
        return "contacts";
    }

    /*TODO refactoring*/
    @RequestMapping(value = "example", method = RequestMethod.GET)
    public String printHtml() {
        return "redirect:/resources/html/example.html";
    }
}
