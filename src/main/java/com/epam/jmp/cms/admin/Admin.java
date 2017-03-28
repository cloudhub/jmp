package com.epam.jmp.cms.admin;

import java.util.List;

/**
 * Created by Aleksei_Okhrimenko on 28.03.2017.
 */
public class Admin {
    List emailList;

    public void setEmailList(List emailList) {
        this.emailList = emailList;
    }

    public List getEmailList() {
        System.out.println("Administrator's emails: " + emailList);
        return emailList;
    }
}
