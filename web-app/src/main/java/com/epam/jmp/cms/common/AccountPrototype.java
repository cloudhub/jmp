package com.epam.jmp.cms.common;

import com.epam.jmp.cms.account.Account;
import com.epam.jmp.cms.account.FacebookAccount;

import java.util.HashMap;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 */
public class AccountPrototype {

    private static HashMap<String, Account> accountMap = new HashMap<String, Account>();

    public static Account getAccount(String accountId) {
        Account prototype = accountMap.get(accountId);
        return (Account) prototype.clone();
    }

    public static void createAccountMap() {
        FacebookAccount facebookAccount = new FacebookAccount();
        facebookAccount.setId("1");
        accountMap.put(facebookAccount.getId(), facebookAccount);
    }
}
