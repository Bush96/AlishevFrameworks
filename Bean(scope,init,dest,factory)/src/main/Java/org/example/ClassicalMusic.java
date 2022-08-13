package org.example;

public class ClassicalMusic implements Music{

    //что касается factory
    public ClassicalMusic (){          //приватный конструктор маст хэв

    }

    public static ClassicalMusic getClassicalMusic(){             //и такой статический геттер
        return new ClassicalMusic();
    }
////////////
    /*
        <bean id="musicBean"
          class="org.example.ClassicalMusic"
    init-method="myInit"
    destroy-method="myDestroy"
    factory-method="getClassicalMusic">         // factory-method="getClassicalMusic"> - говорим что обьект нужно создавать таким образом
    </bean>

     */
    //касаемо инита и дестроя
    public void myInit (){
        System.out.println("sfda");        //те самые инит и дестрой методы обьявляются в классе обьекта

    }

    public void myDestroy(){                     //те самые инит и дестрой методы обьявляются в классе обьекта
        System.out.println("asgasg");
    }

    @Override
    public String getSong() {
        return "Vitja AKA";
    }
}


/*
<bean id="musicBean"
class="org.example.ClassicalMusic"
        init-method="myInit"           //так они помещаются в бин
        destroy-method="myDestroy">
</bean>


 */