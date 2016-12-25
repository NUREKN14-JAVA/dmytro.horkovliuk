package test.java.com.nixsolutions.db;

import static org.junit.Assert.*;

import main.java.com.nixsolutions.usermanagement.db.DaoFactory;
import main.java.com.nixsolutions.usermanagement.db.UserDao;
import org.junit.Test;

public class DaoFactoryTest {

    @Test
    public void testGetUserDao() {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            assertNotNull("DaoFactory instance is null", daoFactory);
            UserDao userDao = daoFactory.getUserDao();
            assertNotNull("UserDao instance is null", userDao);
        } catch (RuntimeException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

}