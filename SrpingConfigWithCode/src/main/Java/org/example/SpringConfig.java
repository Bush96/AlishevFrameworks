package org.example;

import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Configuration

public class SpringConfig {
    @Bean
    public RapMusic rapMusic() {                     //пример ручного создания бина(без @Component i @Autowired)
        return new RapMusic();
    }

    @Bean
    public ShansonMusic shansonMusic() {
        return new ShansonMusic();
    }

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public List<Music> musicList() {

        return Arrays.asList(classicalMusic(), rapMusic(), shansonMusic());
    }


    @Bean
    public MusicPlayer musicPlayer() {                 //пример ручного внедрения зависимостей(без @Component i @Autowired)
        return new MusicPlayer(musicList());
    }

}
