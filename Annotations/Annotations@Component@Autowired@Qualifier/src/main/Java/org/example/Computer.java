package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private musicPlayer musicPlayer;

    @Autowired
    public Computer(musicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    public String toString() {
        return "Computer " + id + " " + musicPlayer.playMusic();
    }

}
