package com.epam.jmp.patterns.facade;

/**
 * Created by alexei.okhrimenko on 14.03.2017.
 */
public class FacadeExample {
    public static void main(String[] args) {
        PhoneCallFacade facade = new PhoneCallFacade();

        facade.callHome();
        facade.callWork();
        facade.callMobile();
    }
}
