package main.java.com.nure.gorkovlyuk.db;

import java.sql.Connection;

public interface ConnectionFactory {
    Connection createConnection() throws DatabaseException;

}