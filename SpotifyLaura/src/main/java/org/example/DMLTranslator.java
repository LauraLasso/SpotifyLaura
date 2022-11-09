package org.example;

public class DMLTranslator {

    private static final String INSERT_TRACK =
            "INSERT INTO tracks(author, title, duration, explicit) VALUES ('%s', '%s', '%d', '%b')";
    private static final String INSERT_ARTIST =
            "INSERT INTO artists(id, name, popularity, followers, genres) VALUES('%s', '%s', '%d', '%d', '%s');";
    private static final String INSERT_ALBUM =
            "INSERT INTO albums(title, author, releaseDate, totalTracks) VALUES('%s', '%s', '%s', '%d')";

    public static String insertStatementOf(Track track){
        return String.format(INSERT_TRACK,
                track.author,
                track.title,
                track.duration,
                track.explicit);
    }

    public static String insertStatementOf(Artist artist){
        return String.format(INSERT_ARTIST,
                artist.id,
                artist.name,
                artist.popularity,
                artist.followers,
                artist.genres);
    }

    public static String insertStatementOf(Album album){
        return String.format(INSERT_ALBUM,
                album.title,
                album.author,
                album.ReleaseDate,
                album.totalTracks);
    }

}
