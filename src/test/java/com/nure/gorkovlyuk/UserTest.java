package test.java.com.nure.gorkovlyuk;


import junit.framework.TestCase;
import main.java.com.nure.gorkovlyuk.User;
import org.junit.Before;
import org.junit.Test;


import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dmitry on 10.10.2016.
 */


public class UserTest extends TestCase {

    private User user;
    private Date dateOfBirthd;

    @Before
    protected void setUp() throws Exception {

        super.setUp();

        user = new User();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, Calendar.MARCH, 11);

        dateOfBirthd = calendar.getTime();

    }

    @Test
    public void testGetFullName() {

        user.setFirstName("Dima");
        user.setLastName("Gorkovlyuk");

        assertEquals("Gorkovlyuk, Dima", user.getFullName());

    }

    @Test
    public void testGetAge() {

        user.setDateOfBirthd(dateOfBirthd);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());

        Calendar c3 = Calendar.getInstance();
        c3.setTime(user.getDateOfBirthd());

        assertEquals(c2.get(Calendar.YEAR) - c3.get(Calendar.YEAR), user.getAge());

    }
}