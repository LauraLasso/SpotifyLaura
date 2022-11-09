package org.example;

import java.util.List;

public interface MusicSource {
    List<Track> tracksOf(String id) throws Exception;

    List<Artist> artistsOf(String id) throws Exception;

    List<Album> albumsOf(String id) throws Exception;
    List<Album> SinglesOf(String ig) throws Exception;

}