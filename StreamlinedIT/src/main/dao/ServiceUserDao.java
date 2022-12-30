package main.dao;

import main.Database.Database;
import main.objects.ServiceUser;

import static main.Enum.UserRole.*;

public class ServiceUserDao {

    private Database database;

    public ServiceUserDao(Database database) {
        this.database = database;
    }

    public ServiceUser createUser(String userName, String userPassword, String userFirstName, String userLastName, String userEmailAddress, String userPhoneNumber) {
        ServiceUser user = new ServiceUser(userName, userPassword, userFirstName, userLastName, userEmailAddress, userPhoneNumber, USER);
        return user;
    }

    public ServiceUser readUser(String userID) {
        ServiceUser user = database.getUsers().stream().filter(u -> u.getUserID().equals(userID)).findFirst().orElse(null);
        return user;
    }

    //TODO: Implement updateUser method
    public ServiceUser updateUser(ServiceUser user) {
        return user;
    }

}

