package main.objects;

import main.Enum.TicketPriority;
import main.Enum.TicketStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class ServiceTicket {

    private int ticketID;
    private String ticketDescription;
    private TicketStatus ticketStatus;
    private TicketPriority ticketPriority;
    private final LocalDateTime ticketDate;
    private final String ticketUserID;

    private static int TICKET_ID = 1;

    public ServiceTicket(String ticketDescription, TicketStatus ticketStatus, TicketPriority ticketPriority, String ticketUserID) {
        this.ticketID = TICKET_ID;
        this.ticketDescription = ticketDescription;
        this.ticketStatus = ticketStatus;
        this.ticketPriority = ticketPriority;
        this.ticketUserID = ticketUserID;
        this.ticketDate = LocalDateTime.now();
        TICKET_ID++;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public ServiceTicket setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
        return this;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public TicketPriority getTicketPriority() {
        return ticketPriority;
    }

    public LocalDateTime getTicketDate() {
        return ticketDate;
    }

    public String getTicketUserID() {
        return ticketUserID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceTicket)) return false;
        ServiceTicket that = (ServiceTicket) o;
        return getTicketID() == that.getTicketID() && getTicketDescription().equals(that.getTicketDescription()) &&
                getTicketStatus().equals(that.getTicketStatus()) && getTicketPriority().equals(that.getTicketPriority())
                && getTicketDate().equals(that.getTicketDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicketID(), getTicketDescription(),
                getTicketStatus(), getTicketPriority(), getTicketDate());
    }
}
