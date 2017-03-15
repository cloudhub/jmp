package com.epam.jmp.patterns.adapter;

/**
 * Created by alexei.okhrimenko on 15.03.2017.
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    public void playMp4(String fileName) {
    }
}
