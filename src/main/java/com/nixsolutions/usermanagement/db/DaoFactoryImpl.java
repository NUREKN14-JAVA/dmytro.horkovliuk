package main.java.com.nixsolutions.usermanagement.db;

/**
 * Created by Dmitry on 26.12.2016.
 */
public class DaoFactoryImpl extends DaoFactory {

    @Override
    public UserDao getUserDao() {
        {
            UserDao result = null;
            try {
                Class clazz = Class.forName(properties.getProperty(USER_DAO));
                result = (UserDao) clazz.newInstance();
                result.setConnectionFactory(getConnectionFactory());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return result;
        }
    }
}
