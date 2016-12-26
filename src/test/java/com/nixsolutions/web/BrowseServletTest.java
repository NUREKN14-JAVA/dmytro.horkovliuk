package test.java.com.nixsolutions.web;

import main.java.com.nixsolutions.usermanagement.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BrowseServletTest  extends MockServletTestCase {

    @Before
    protected void setUp() throws Exception {
        super.setUp();
        createServlet(BrowseServlet.class);
    }


    @Test
    public void testBrowse() {
        User user = new User(new Long(1000), "John", "Doe", new Date());
        List list = Collections.singletonList(user);
        getMockUserDao().expectAndReturn("findAll", list);
        doGet();
        Collection collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
        assertNotNull("Could not find list of users in session", collection);
        assertSame(list, collection);
    }

}