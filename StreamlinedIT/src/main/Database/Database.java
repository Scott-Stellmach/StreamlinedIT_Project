package main.Database;

import main.objects.ServiceTicket;
import main.objects.ServiceUser;

import java.util.List;

public class Database {

    private List<ServiceUser> users;
    private List<ServiceTicket> tickets;

    public Database() {}

    public List<ServiceUser> getUsers() {
        return users;
    }

    public Database setUsers(List<ServiceUser> users) {
        this.users = users;
        return this;
    }

    public List<ServiceTicket> getTickets() {
        return tickets;
    }

    public Database setTickets(List<ServiceTicket> tickets) {
        this.tickets = tickets;
        return this;
    }
}

