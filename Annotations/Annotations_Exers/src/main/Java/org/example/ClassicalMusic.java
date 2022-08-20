package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music {
    public void getSong() {

        List<String> classicalSongsList = new ArrayList();
        classicalSongsList.add("Бах");
        classicalSongsList.add("Чайковский");
        classicalSongsList.add("Бетховен");

        Collections.shuffle(classicalSongsList);

        System.out.println(classicalSongsList.get(0));

    }


}
