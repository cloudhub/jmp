package com.epam.jmp.model;

import java.util.Objects;

/**
 * Created by alexei.okhrimenko on 10.02.2017.
 */
public class Contact {

    private Contact() {
    }

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class ContactBuilder {
        private Contact contact = new Contact();

        public ContactBuilder() {
        }

        public Contact build() {
            return contact;
        }

        public ContactBuilder id(String id) {
            contact.id = id;
            return this;
        }

        public ContactBuilder firstName(String firstName) {
            contact.firstName = firstName;
            return this;
        }

        public ContactBuilder lastName(String lastName) {
            contact.lastName = lastName;
            return this;
        }

        public ContactBuilder email(String email) {
            contact.email = email;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) &&
                Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
