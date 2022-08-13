package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");   //дефолтный класс, который позволяет работать с папкой recources
        // "applicationContext.xml" - это должно обязательно лежать в папке помеченной MARK ROOT

        musicPlayer firsmusicPlayer = contex.getBean("musicPlayer", org.example.musicPlayer.class);
        musicPlayer secondmusicPlayer = contex.getBean("musicPlayer", musicPlayer.class);

        boolean comparing = firsmusicPlayer == secondmusicPlayer;      //при scope singleton  будет тру, первый вызов создает обьект, второй создает ссылку на обьект
        firsmusicPlayer.getVolume(20);      //так же при singleton величина будет меняться на всех обьектах, не только на вызванном
        System.out.println(comparing);

        // System.out.println(musicPlayer.getName() + " " + musicPlayer.getVolume());

        contex.close();

    }
}

/*
<bean id="musicPlayer"
class="org.example.musicPlayer"
        scope="prototype">             //ставя здесь этот скоуп мы создаем уже отдельные обьекты, где и сравнения не будут тру и для каждого проигрывателя нужно будет ставить свои значения звука и тп
<property name="music" ref="musicBean"/>

<property name="name" value="${musicPlayer.name}"/>
<property name="volume" value="${musicPlayer.volume}"/>
</bean>


 */
