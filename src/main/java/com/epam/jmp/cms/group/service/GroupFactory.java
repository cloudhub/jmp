package com.epam.jmp.cms.group.service;

import com.epam.jmp.cms.common.UserAbstractFactory;
import com.epam.jmp.cms.group.dao.GroupDao;
import com.epam.jmp.cms.group.model.Coworkers;
import com.epam.jmp.cms.group.model.Friends;
import com.epam.jmp.cms.group.model.Support;
import com.epam.jmp.cms.phone.dao.PhoneDao;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public class GroupFactory extends UserAbstractFactory {

    @Override
    public GroupDao createGroup(String group) {
        if (group == null) {
            return null;
        }
        if (group.equals("FRIENDS")) {
            return new Friends();
        } else if (group.equals("COWORKERS")) {
            return new Coworkers();
        } else if (group.equals("SUPPORT")) {
            return new Support();
        }
        return null;
    }

    @Override
    public PhoneDao cretePhone(String phone) {
        return null;
    }

}
