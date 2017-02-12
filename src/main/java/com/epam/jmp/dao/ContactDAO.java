package com.epam.jmp.dao;

import com.epam.jmp.model.Contact;
import com.epam.jmp.utils.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Created by alexei.okhrimenko on 12.02.2017.
 */

@Repository
public class ContactDAO {

    @Value(value = "classpath:/data.xml")
    private Resource resource;

    public HashMap<String, Contact> getContactsFromXml() {
        HashMap<String, Contact> contactList = new HashMap<String, Contact>();
        try {
            Converter.xmlToObject(contactList, resource);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return contactList;
    }

    public void deleteContact(String id) {
        try {
            Converter.deleteContact(id, resource);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
