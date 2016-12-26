package test.java.com.nixsolutions.db;

import main.java.com.nixsolutions.usermanagement.db.DaoFactory;
import main.java.com.nixsolutions.usermanagement.db.UserDao;

public class MockDaoFactory extends DaoFactory {

	private Mock mockUserDao;
	
	public MockDaoFactory() {
		mockUserDao = new Mock(UserDao.class);
	}
	
	public Mock getMockUserDao() {
		return mockUserDao;
	}
	
	public UserDao getUserDao() {
		return (UserDao) mockUserDao.proxy();
	}

}
