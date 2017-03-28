package com.epam.jmp.patterns.facade;

/**
 * Created by alexei.okhrimenko on 14.03.2017.
 */
public class PhoneCallFacade {
    private Home home;
    private Work work;
    private Mobile mobile;

    public PhoneCallFacade() {
        home = new Home();
        work = new Work();
        mobile = new Mobile();
    }

    public void callHome() {
        home.call();
    }

    public void callWork() {
        work.call();
    }

    public void callMobile() {
        mobile.call();
    }
}
