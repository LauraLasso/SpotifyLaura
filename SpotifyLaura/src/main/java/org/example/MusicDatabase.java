package org.example;

import java.sql.SQLException;

public interface MusicDatabase {
    void add(Track track) throws SQLException;
    void add(Album albums) throws SQLException;
    void add(Artist artist) throws SQLException;
}
