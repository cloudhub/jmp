package com.epam.jmp.cms.group.service;

import com.epam.jmp.cms.group.dao.GroupDao;
import com.epam.jmp.cms.group.model.Coworkers;
import com.epam.jmp.cms.group.model.Friends;
import com.epam.jmp.cms.group.model.Support;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public class GroupFactory {
    public GroupDao createLabel(String label) {
        if (label == null) {
            return null;
        }
        if (label.equals("FRIENDS")) {
            return new Friends();
        } else if (label.equals("COWORKERS")) {
            return new Coworkers();
        } else if (label.equals("SUPPORT")) {
            return new Support();
        }
        return null;
    }
}
