package com.epam.jmp.cms.group.model;

import com.epam.jmp.cms.group.dao.GroupDao;

/**
 * Created by alexei.okhrimenko on 08.03.2017.
 */
public class Support implements GroupDao {
    public void createLabel() {
        System.out.println("Support");
    }
}
