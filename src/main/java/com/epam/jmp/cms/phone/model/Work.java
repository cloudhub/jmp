package com.epam.jmp.cms.phone.model;

import com.epam.jmp.cms.phone.dao.PhoneDao;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public class Work implements PhoneDao {
    public void createPhone() {
        System.out.println("Work phone");
    }
}
