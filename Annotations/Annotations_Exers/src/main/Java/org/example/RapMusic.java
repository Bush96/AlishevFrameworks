package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class RapMusic implements Music {

    public void getSong() {

        List<String> rapSongsList = new ArrayList();
        rapSongsList.add("Тупак");
        rapSongsList.add("Витя ак");
        rapSongsList.add("Дора");

        Collections.shuffle(rapSongsList);

        System.out.println(rapSongsList.get(0));

    }
}
