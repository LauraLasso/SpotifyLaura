package org.example;

public class Track {

    String author;
    String title;
    boolean explicit;
    int duration;

    public Track(String title, String author, int duration, boolean explicit) {
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.explicit = explicit;
    }

}
