package test.java.com.nixsolutions.db;


import main.java.com.nixsolutions.usermanagement.User;
import main.java.com.nixsolutions.usermanagement.db.ConnectionFactory;
import main.java.com.nixsolutions.usermanagement.db.ConnectionFactoryImpl;
import main.java.com.nixsolutions.usermanagement.db.DatabaseException;
import main.java.com.nixsolutions.usermanagement.db.HsqldbUserDao;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class HsqldbUserDaoTest extends DatabaseTestCase {
    private HsqldbUserDao dao;
    private ConnectionFactory connectionFactory;
    private Date tempDate;


    protected void setUp() throws Exception {
        super.setUp();
        dao = new HsqldbUserDao(connectionFactory);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1984, Calendar.MAY, 26);
        tempDate = calendar.getTime();
    }

    public void testCreate() {
        try {
            User user = new User();
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setDateOfBirthd(tempDate);

            assertNull(user.getId());

            user = dao.create(user);
            assertNotNull(user);
            assertNotNull(user.getId());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    public void testFindAll() {
        try {
            Collection collection = dao.findAll();
            assertNotNull("Collection is null", collection);
            assertEquals("Collection size.", 2, collection.size());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    public void testFind() {
        try {
            User user = new User();
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setDateOfBirthd(tempDate);
            user = dao.create(user);
            User tempUser = dao.find(user.getId());
            assertEquals("Found wrong user", tempUser.getLastName(), user.getLastName());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    public void testUpdate() {
        try {
            User user = new User();
            user.setFirstName("Marti");
            user.setLastName("Luter");
            user.setDateOfBirthd(tempDate);

            User userTest = dao.create(user);
            userTest.setFirstName("Ivan");
            userTest.setLastName("Groaznyi");
            userTest.setDateOfBirthd(tempDate);
            userTest.setId(user.getId());

            dao.update(userTest);

        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }


    public void testDelete() {
        try {
            User user = new User();

            user.setFirstName("John");
            user.setLastName("Doe");
            user.setDateOfBirthd(tempDate);

            user = dao.create(user);

            dao.delete(user);

        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver", "jdbc:hsqldb:file:db/usermanagement", "sa", "");
        return new DatabaseConnection(connectionFactory.createConnection());
    }
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
        return dataSet;
    }

}