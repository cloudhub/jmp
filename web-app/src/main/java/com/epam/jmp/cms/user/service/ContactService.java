package com.epam.jmp.cms.user.service;

import com.epam.jmp.cms.user.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexei.okhrimenko on 07.02.2017.
 */

public interface ContactService {
    List<Contact> findAll();
    Contact findById(int id);
    void create(Contact contact);
    void update(Contact contact);
    void delete(int id);
}