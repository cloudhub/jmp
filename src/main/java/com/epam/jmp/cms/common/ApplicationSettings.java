package com.epam.jmp.cms.common;

/**
 * Created by alexei.okhrimenko on 09.03.2017.
 * singleton pattern
 */
public class ApplicationSettings {
    private static ApplicationSettings settings = new ApplicationSettings();

    private ApplicationSettings() {
    }

    public static ApplicationSettings getSettings() {
        return settings;
    }
}
