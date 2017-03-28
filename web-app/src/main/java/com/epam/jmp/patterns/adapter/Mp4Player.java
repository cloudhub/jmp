package com.epam.jmp.patterns.adapter;

/**
 * Created by alexei.okhrimenko on 15.03.2017.
 */
public class Mp4Player implements AdvancedMediaPlayer {

    public void playVlc(String fileName) {
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
