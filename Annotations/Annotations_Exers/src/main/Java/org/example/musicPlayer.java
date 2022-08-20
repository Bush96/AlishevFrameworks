package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class musicPlayer {
    private Music music2;
    private Music music1;



    @Autowired
    public musicPlayer(@Qualifier("classicalMusic") Music music2, @Qualifier("rapMusic") Music music1) {            //так внедряется кваливайр при неопеделенности бинов
        this.music2 = music2;
        this.music1 = music1;

    }


    public void playMusic(MusicJenre musicJenre) {
        if (musicJenre == MusicJenre.CLASSIC) {
            music2.getSong();
        } else if( musicJenre == MusicJenre.RAP){
            music1.getSong();}

    }

}


