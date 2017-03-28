package com.epam.jmp.cms.common;

import com.epam.jmp.cms.group.dao.GroupDao;
import com.epam.jmp.cms.phone.dao.PhoneDao;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public abstract class UserAbstractFactory {
    public abstract GroupDao createGroup(String group);

    public abstract PhoneDao cretePhone(String phone);
}
