package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final List<String> ArtistIds = Arrays.asList(
            "0jeYkqwckGJoHQhhXwgzk3",
            "0Q8NcsJwoCbZOHHW63su5S",
            "5lWasZeo8uWQk6GD8czJLq",
            "2IMZYfNi21MGqxopj9fWx8",
            "2cFrymmkijnjDg9SS92EPM"
    );


    public static void main(String[] args) throws Exception {
        MusicSource source = new Json();
        MusicDatabase musicDatabase = new SqliteMusicDatabase();

        for (String id: ArtistIds) {
            updateArtist(source, musicDatabase, id);
            uploadAlbums(source, musicDatabase, id);
            uploadTracks(source, musicDatabase, id);
        }
    }

    private static void uploadTracks(MusicSource source, MusicDatabase musicDatabase, String id) throws Exception {
        List<Track> tracks = source.tracksOf(id);
        for (Track track : tracks) {
            musicDatabase.add(track);
        }
    }

    private static void uploadAlbums(MusicSource source, MusicDatabase musicDatabase, String id) throws Exception {
        List<Album> albums = source.albumsOf(id);
        List<Album> singles = source.SinglesOf(id);
        for (Album album : albums) {
            musicDatabase.add(album);
        }
        for(Album single : singles){
            musicDatabase.add(single);
        }
    }

    private static void updateArtist(MusicSource source, MusicDatabase musicDatabase, String id) throws Exception {
        List<Artist> artists = source.artistsOf(id);
        for (Artist artist : artists) {
            musicDatabase.add(artist);
        }
    }


}