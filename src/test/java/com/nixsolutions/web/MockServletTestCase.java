package test.java.com.nixsolutions.web;

import main.java.com.nixsolutions.usermanagement.db.DaoFactory;
import org.junit.After;
import org.junit.Before;
import test.java.com.nixsolutions.db.MockDaoFactory;

import java.util.Properties;

public class MockServletTestCase extends BasicServletTestCaseAdapter {

    private Mock mockUserDao;

    @Before
    protected void setUp() throws Exception {
        super.setUp();
        Properties properties = new Properties();
        properties.setProperty("dao.factory", MockDaoFactory.class.getName());
        DaoFactory.init(properties);
        setMockUserDao(((MockDaoFactory) DaoFactory.getInstance()).getMockUserDao());
    }

    /**
     * @return the mockUserDao
     */
    public Mock getMockUserDao() {
        return mockUserDao;
    }

    /**
     * @param mockUserDao the mockUserDao to set
     */
    public void setMockUserDao(Mock mockUserDao) {
        this.mockUserDao = mockUserDao;
    }

    @After
    protected void tearDown() throws Exception {
        getMockUserDao().verify();
        super.tearDown();
    }

}
