package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class musicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private Music music2;
    private Music music1;

    @Autowired
    public musicPlayer(@Qualifier("classicalMusic") Music music2, @Qualifier("rapMusic") Music music1) {            //так внедряется кваливайр при неопеделенности бинов
        this.music2 = music2;
        this.music1 = music1;
    }


    public String playMusic() {
        return "Playing : " + music1.getSong() + ", " + music2.getSong();

    }

}


