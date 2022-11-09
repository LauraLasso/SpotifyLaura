package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteMusicDatabase implements MusicDatabase{

    private final Connection connection;

    public SqliteMusicDatabase() throws SQLException {
        String url ="jdbc:sqlite:database.db";
        connection = DriverManager.getConnection(url);
        initDatabase();
    }

    private static final String INIT =
            "CREATE TABLE IF NOT EXISTS tracks (" +
                    "title TEXT, " +
                    "author TEXT, " +
                    "duration NUMBER, " +
                    "explicit BOOLEAN);";
    private static final String INIT2 =
            "CREATE TABLE IF NOT EXISTS artists (" +
                    "id TEXT PRIMARY KEY, " +
                    "name TEXT, " +
                    "popularity NUMBER, " +
                    "followers NUMBER," +
                    "genres TEXT);";

    private static final String INIT3 =
            "CREATE TABLE IF NOT EXISTS albums (" +
                    "title TEXT, " +
                    "author TEXT, " +
                    "ReleaseDate TEXT, " +
                    "totalTracks NUMBER);";

    private void initDatabase() throws SQLException{
        connection.createStatement().execute(INIT);
        connection.createStatement().execute(INIT2);
        connection.createStatement().execute(INIT3);
    }

    @Override
    public void add(Track track) throws SQLException {
        try{
            connection.createStatement().execute(DMLTranslator.insertStatementOf(track));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Album albums) throws SQLException {
        try{
            connection.createStatement().execute(DMLTranslator.insertStatementOf(albums));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Artist artist) throws SQLException {
        try{
            connection.createStatement().execute(DMLTranslator.insertStatementOf(artist));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
