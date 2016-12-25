package main.java.com.nure.gorkovlyuk.db;

import main.java.com.nure.gorkovlyuk.User;

import java.util.Collection;

    public interface UserDao {
        User create(User user) throws DatabaseException;

        void update(User user) throws DatabaseException;

        void delete(User user) throws DatabaseException;

        User find(Long id) throws DatabaseException;

        Collection findAll() throws DatabaseException;
}

