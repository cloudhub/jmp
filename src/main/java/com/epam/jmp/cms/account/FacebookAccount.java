package com.epam.jmp.cms.account;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public class FacebookAccount extends Account {

    public FacebookAccount() {
        type = "Facebook";
    }

    @Override
    void createAccount() {
        System.out.println("facebook account");
    }
}
