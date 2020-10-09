package by.alx.flightassist.dao;

import by.alx.flightassist.dao.UserDAO;
import by.alx.flightassist.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserImpl = new SQLUserDAO();

    private DAOFactory() {

    }

    private static DAOFactory getInstance(){
        return instance;
    }

    public UserDAO getSqlUserDAO(){
        return sqlUserImpl;
    }
}
