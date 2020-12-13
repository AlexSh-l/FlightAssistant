package by.alx.flightassist.dao;

import by.alx.flightassist.dao.UserDAO;
import by.alx.flightassist.dao.impl.SQLFlightDAO;
import by.alx.flightassist.dao.impl.SQLUserDAO;
import by.alx.flightassist.bean.User;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserImpl = new SQLUserDAO();
    private final FlightDAO sqlFlightDAO = new SQLFlightDAO();

    public DAOFactory() {

    }

    private static DAOFactory getInstance(){
        return instance;
    }

    public UserDAO getSqlUserDAO(){
        return sqlUserImpl;
    }
    public FlightDAO getSqlFlightDAO() { return sqlFlightDAO; }
}
