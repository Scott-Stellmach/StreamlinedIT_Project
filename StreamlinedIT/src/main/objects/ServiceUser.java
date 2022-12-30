package main.objects;

import main.Enum.UserRole;

import java.util.List;
import java.util.Objects;

public class ServiceUser {

    private String userID;
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userEmailAddress;
    private String userPhoneNumber;
    private final UserRole userRole;
    private List<ServiceTicket> associatedTickets;

    public ServiceUser(String userName, String userPassword, String userFirstName, String userLastName, String userEmailAddress, String userPhoneNumber, UserRole userRole) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmailAddress = userEmailAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userRole = userRole;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public List<ServiceTicket> getAssociatedTickets() {
        return associatedTickets;
    }

    public void setAssociatedTickets(List<ServiceTicket> associatedTickets) {
        this.associatedTickets = associatedTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceUser)) return false;
        ServiceUser that = (ServiceUser) o;
        return getUserID().equals(that.getUserID()) && getUserName().equals(that.getUserName()) &&
                Objects.equals(getUserFirstName(), that.getUserFirstName()) &&
                getUserLastName().equals(that.getUserLastName()) && getUserPassword().equals(that.getUserPassword()) &&
                getUserEmailAddress().equals(that.getUserEmailAddress()) &&
                getUserPhoneNumber().equals(that.getUserPhoneNumber()) && getUserRole().equals(that.getUserRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getUserName(), getUserPassword(), getUserRole());
    }
}
