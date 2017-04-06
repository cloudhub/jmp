package com.epam.jmp.cms.user.dao;

import com.epam.jmp.cms.user.model.Contact;
import com.epam.jmp.dao.BaseDao;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Aleksei_Okhrimenko on 04.04.2017.
 */
@Repository
public class ContactDao extends BaseDao {

    public static final Logger LOGGER = Logger.getLogger(ContactDao.class);

    public List<Contact> findAll() {
        String sql = "SELECT * FROM contacts";
        List<Contact> contacts = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Contact.class));
        return contacts;
    }

    public Contact findById(int id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        Contact contact = (Contact) jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper(Contact.class));
        return contact;
    }

    public void create(Contact contact) {
        String sql = "INSERT INTO contacts (firstname, lastname, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{contact.getFirstName(), contact.getLastName(), contact.getEmail()});
    }

    public void update(Contact contact) {
        String sql = "UPDATE contacts SET firstname=?,lastname=?,email=? WHERE id=?";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM contacts WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
