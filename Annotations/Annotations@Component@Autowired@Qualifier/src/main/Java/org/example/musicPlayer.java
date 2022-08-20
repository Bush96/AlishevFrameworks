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

//    Способы внедрения зависимостей:
//    @Autowired
//    private Music music;

//    @Autowired
//    public musicPlayer(Music music) {       //заводим конструктор для связи для связи со Spring при помощи IoC посредством XML
//        this.music = music;
//    }

//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }

    public String playMusic() {
        return "Playing : " + music1.getSong() + ", " + music2.getSong();

    }

}


