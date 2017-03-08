package com.epam.jmp.cms.phone.service;

import com.epam.jmp.cms.phone.dao.PhoneDao;
import com.epam.jmp.cms.phone.model.Home;
import com.epam.jmp.cms.phone.model.Mobile;
import com.epam.jmp.cms.phone.model.Work;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public class PhoneFactory {
    public PhoneDao createPhone(String phone) {
        if (phone == null) {
            return null;
        }
        if (phone.equals("HOME")) {
            return new Home();
        } else if (phone.equals("WORK")) {
            return new Work();
        } else if (phone.equals("MOBILE")) {
            return new Mobile();
        }
        return null;
    }
}
