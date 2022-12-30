package main;

import main.Database.Database;
import main.controllers.Controller;
import main.dao.ServiceTicketDao;
import main.dao.ServiceUserDao;

public class Startup {

    public Database getDatabase() {
        return new Database();
    }

    public ServiceUserDao getUserDao() {
        return new ServiceUserDao(getDatabase());
    }

    public ServiceTicketDao getTicketDao() {
        return new ServiceTicketDao(getDatabase());
    }

    public Controller getController() {
        return new Controller(getTicketDao(), getUserDao());
    }
}
