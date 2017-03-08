package com.epam.jmp.cms.phone.service;

import com.epam.jmp.cms.common.UserAbstractFactory;
import com.epam.jmp.cms.group.dao.GroupDao;
import com.epam.jmp.cms.phone.dao.PhoneDao;
import com.epam.jmp.cms.phone.model.Home;
import com.epam.jmp.cms.phone.model.Mobile;
import com.epam.jmp.cms.phone.model.Work;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public class PhoneFactory extends UserAbstractFactory {

    @Override
    public GroupDao createGroup(String group) {
        return null;
    }

    @Override
    public PhoneDao cretePhone(String phone) {
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
