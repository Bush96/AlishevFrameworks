package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");   //дефолтный класс, который позволяет работать с папкой recources
        // "applicationContext.xml" - это должно обязательно лежать в папке помеченной MARK ROOT

        musicPlayer musicPlayer = contex.getBean("musicPlayer", org.example.musicPlayer.class);

        musicPlayer.playMusic();

        System.out.println(musicPlayer.getName() + " " + musicPlayer.getVolume());
        
        contex.close();

    }
}


//комменты к applicationContext

//<bean id="musicBean"
//class="org.example.shansonMusic">
//</bean>

//<bean id="musicPlayer"
//class="org.example.musicPlayer">
//<property name="music" ref="musicBean"/>     //пиша здесь music, спринг ищет на самом деле сетеер setMusic
//</bean>

//</beans>