package com.epam.jmp.cms.user.model;

/**
 * Created by alexei.okhrimenko on 17.02.2017.
 */
public class ContactBuilder {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public Contact build() {
        return new Contact(id, firstName, lastName, email);
    }

    public ContactBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ContactBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder email(String email) {
        this.email = email;
        return this;
    }
}
