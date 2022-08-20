package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");   //дефолтный класс, который позволяет работать с папкой recources
        // "applicationContext.xml" - это должно обязательно лежать в папке помеченной MARK ROOT

//        musicPlayer musicPlayer = contex.getBean("musicPlayer", org.example.musicPlayer.class);
//        musicPlayer.playMusic();

        musicPlayer musicPlayer = contex.getBean("musicPlayer", musicPlayer.class);
        musicPlayer.playMusic(MusicJenre.CLASSIC);
        contex.close();

    }
}

// applicaton context
// <context:component-scan base-package="org.example"/>         при аннотации мы в этом файле имеем лишь единственную строку, путь к папке с обьектами
//
//</beans>
