package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");   //дефолтный класс, который позволяет работать с папкой recources
        // "applicationContext.xml" - это должно обязательно лежать в папке помеченной MARK ROOT


        musicPlayer musicPlayer = contex.getBean("musicPlayer", musicPlayer.class);

        musicPlayer.playMusic();
        contex.close();

    }
}


//комменты к applicationContext

//ВСЕЕ ЭТО НАМ НУЖНО ДЛЯ УДОБСТВА (ioc) INVERSION ON CONTROL - ОНО НАМ НУЖНО ПОТОМУ ЧТО ПЛЮСОВ КУЧА, ОДИН ИЗ - ВОЗМОЖНОСТЬ НЕ МЕНЯЯ КОД ПРОГРАММЫ МЫ МОЖЕМ БЫСТРО И ГИБКО МЕНЯТЬ ОБЬЕКТЫ ДЛЯ СОЗДАНИЯ, ОБНОВЛЕНИЯ, ДОПОЛНЕНИЯ НАШЕЙ ПРОГРАММЫ

//   <bean id="musicBean"                            //создаем бины(обьекты) тех сущностей которые имплементят интерфейс музык и явзяются жанрами музыки
//          class="org.example.RapMusic">          //связываем обьект musicBean с обьектом который мы будем создавать (не нужно лезть в код чтобы поменять создаваемый обьект, достаточно здесь поменять жанр на иной)
//    </bean>
//    <bean id="musicPlayer"                      //1 чтобы не создавать в коде вручную обьект плейера, мы создаем его тут
//          class="org.example.musicPlayer">           //2 так же указываем путь
//        <constructor-arg ref="musicBean"/>          //3 т.к. у плейера есть конструктор мы обязаны передать аргумент, в данном случаи сразу передаем верхний бин муз.плейера
//    </bean>