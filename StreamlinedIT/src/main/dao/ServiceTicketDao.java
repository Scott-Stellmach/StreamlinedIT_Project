package main.dao;

import main.Database.Database;
import main.objects.ServiceTicket;

import java.util.List;
import java.util.Scanner;

import static main.Enum.TicketPriority.MEDIUM;
import static main.Enum.TicketStatus.OPEN;

public class ServiceTicketDao {

    private Database database;

    public ServiceTicketDao(Database database) {
        this.database = database;
    }

    public ServiceTicket createTicket(String ticketDescription, String ticketUserID) {
        ServiceTicket ticket = new ServiceTicket(ticketDescription, OPEN, MEDIUM, ticketUserID);
        database.getTickets().add(ticket);
        return ticket;
    }

    public ServiceTicket readTicket(String ticketID) {
        List<ServiceTicket> tickets = database.getTickets();
        ServiceTicket ticketToRead = null;
        for (ServiceTicket ticket : tickets) {
            if (ticket.getTicketID() == Integer.parseInt(ticketID)) {
                ticketToRead = ticket;
            } else {
                return null;
            }
        }
        return ticketToRead;
    }

    public void updateTicket(String ticketID) {
        ServiceTicket ticket = readTicket(ticketID);
        String currentDescription = ticket.getTicketDescription();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current ticket description: " + currentDescription);
        System.out.println("Enter the update to the ticket description: ");
        String updateToDescription = scanner.nextLine();
        ticket.setTicketDescription(currentDescription + updateToDescription);
        System.out.println("Ticket description updated to: " + ticket.getTicketDescription());
    }

    public void deleteTicket(String ticketID) {
        ServiceTicket ticket = readTicket(ticketID);
        database.getTickets().remove(ticket);
        System.out.println("Ticket deleted.");
    }
}

