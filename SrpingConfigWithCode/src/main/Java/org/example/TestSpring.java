package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpring {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class); // теперь спринг мы подтягиваем так
        MusicPlayer musicPlayer = context.getBean("musicPlayer", org.example.MusicPlayer.class);

        musicPlayer.playMusic();

        context.close();

    }
}


// applicaton context
// <context:component-scan base-package="org.example"/>         при аннотации мы в этом файле имеем лишь единственную строку, путь к папке с обьектами
//
//</beans>
