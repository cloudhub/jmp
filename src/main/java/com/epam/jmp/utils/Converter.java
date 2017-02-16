package com.epam.jmp.utils;

import com.epam.jmp.model.Contact;
import com.epam.jmp.model.ContactBuilder;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.HashMap;

/**
 * Created by alexei.okhrimenko on 11.02.2017.
 */
public class Converter {

    public static void xmlToObject(HashMap<String, Contact> contactList, Resource resource)
            throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = resource.getInputStream();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        document.getDocumentElement().normalize();

        NodeList list = document.getElementsByTagName("contact");

        for (int count = 0; count < list.getLength(); count++) {
            Node node = list.item(count);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                Contact contact = new ContactBuilder()
                        .id(element.getElementsByTagName("id").item(0).getTextContent())
                        .firstName(element.getElementsByTagName("firstName").item(0).getTextContent())
                        .lastName(element.getElementsByTagName("lastName").item(0).getTextContent())
                        .email(element.getElementsByTagName("email").item(0).getTextContent())
                        .build();

                contactList.put(element.getElementsByTagName("id").item(0).getTextContent(), contact);
            }
        }
    }

    public static void deleteContact(String id, Resource resource)
            throws IOException, SAXException, ParserConfigurationException, TransformerException, URISyntaxException {
        InputStream inputStream = resource.getInputStream();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        NodeList nodes = document.getElementsByTagName("contact");
        for (int count = 0; count < nodes.getLength(); count++) {
            Element contact = (Element) nodes.item(count);
            Element elementId = (Element) contact.getElementsByTagName("id").item(0);
            String sId = elementId.getTextContent();
            if (sId.equals(id)) {
                contact.getParentNode().removeChild(contact);
            }
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(new File("data.xml")));
    }

    public static void parse() throws Exception {
        File file = ResourceUtils.getFile("classpath:/data.xml");
        System.out.println("File Found : " + file.exists());
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);
    }
}
