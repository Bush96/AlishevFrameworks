package org.example;

public class musicPlayer {
    private Music music;
    private String name;
    private int volume;



    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    //IoC
    public musicPlayer(Music music) {       //заводим конструктор для связи для связи со Spring при помощи IoC посредством XML
        this.music = music;
    }

    public musicPlayer() {

    }

    public void setMusic(Music music) {
        this.music = music;

    }

    public void playMusic() {
        System.out.println("Playing : " + music.getSong());
    }

}


