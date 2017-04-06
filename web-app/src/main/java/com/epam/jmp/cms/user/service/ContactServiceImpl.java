package com.epam.jmp.cms.user.service;

import com.epam.jmp.cms.user.dao.ContactDao;
import com.epam.jmp.cms.user.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aleksei_Okhrimenko on 04.04.2017.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao dao;

    @Override
    public List<Contact> findAll() {
        return dao.findAll();
    }

    @Override
    public Contact findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void create(Contact contact) {
        dao.create(contact);
    }

    @Override
    public void update(Contact contact) {
        dao.update(contact);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
