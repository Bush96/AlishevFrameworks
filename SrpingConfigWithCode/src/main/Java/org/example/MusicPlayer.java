package org.example;


import java.util.List;
import java.util.Random;


public class MusicPlayer {

    private List<Music> musicList;

    public MusicPlayer(List<Music> musicList) {            //так внедряется кваливайр при неопеделенности бинов
        this.musicList = musicList;

    }

    public String playMusic() {
        Random random = new Random();

        return "Playing: " + musicList.get(random.nextInt(musicList.size())).getSong();
        }
    }



