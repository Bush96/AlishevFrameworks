package org.example;

import org.springframework.stereotype.Component;

public class RapMusic implements Music {

    @Override
    public String getSong() {
        return "TupakEU";
    }
}
