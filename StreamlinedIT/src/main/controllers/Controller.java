package main.controllers;

import main.dao.ServiceTicketDao;
import main.dao.ServiceUserDao;
import main.objects.ServiceTicket;
import main.objects.ServiceUser;

import java.util.Scanner;

public class Controller {

    private ServiceTicketDao ticketDao;
    private ServiceUserDao userDao;

    private ServiceUser currentUser;

    private int useAttempts = 0;

    public Controller( ServiceTicketDao ticketDao, ServiceUserDao userDao ) {
        this.ticketDao = ticketDao;
        this.userDao = userDao;
    }

    public void Start(){

        //TODO:  Lots of helper methods here to make this method more readable
        System.out.println("Please login to continue, if you do not have an account please create one now.\n" +
                " Select an option below:\n" +
                " 1. Login\n" +
                " 2. Create Account\n" +
                " 3. Exit");

        Scanner scanner;
        int option = 0;

        while (option != 1 && option != 2 && option != 3) {
            scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option == 1) {
                login();
            } else if (option == 2) {
                createAccount();
            } else if (option == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }

        while(true){
            int function = welcome();
            switch (function) {
                case 1:
                    System.out.println("You selected to create a ticket.");
                    scanner = new Scanner(System.in);
                    System.out.println("Please enter a ticket description: ");
                    String ticketDescription = scanner.nextLine();
                    ServiceTicket serviceTicket = ticketDao.createTicket(ticketDescription, currentUser.getUserID());
                    ;
                    System.out.println("Your ticket has been created with the following information:\n" +
                            "Ticket ID: " + serviceTicket.getTicketID() + "\n" +
                            "Ticket Description: " + serviceTicket.getTicketDescription() + "\n" +
                            "Ticket Status: " + serviceTicket.getTicketStatus() + "\n" +
                            "Ticket Priority: " + serviceTicket.getTicketPriority() + "\n" +
                            "Ticket Date: " + serviceTicket.getTicketDate());
                    System.out.println("Thank you for using the StreamlinedIT system. A service representative will be with you shortly.");
                    break;
                case 2:
                    System.out.println("You selected to view a ticket.");
                    scanner = new Scanner(System.in);
                    System.out.println("Please enter the ticket ID: ");
                    String ticketID = scanner.nextLine();
                    ServiceTicket ticket = ticketDao.readTicket(ticketID);
                    if(ticket != null){
                        System.out.println("Ticket ID: " + ticket.getTicketID() + "\n" +
                                "Ticket Description: " + ticket.getTicketDescription() + "\n" +
                                "Ticket Status: " + ticket.getTicketStatus() + "\n" +
                                "Ticket Priority: " + ticket.getTicketPriority() + "\n" +
                                "Ticket Date: " + ticket.getTicketDate());
                    } else {
                        System.out.println("Ticket not found.");
                    }
                    break;
                case 3:
                    System.out.println("You selected to update a ticket.");
                    scanner = new Scanner(System.in);
                    System.out.println("Please enter the ticket ID: ");
                    String ticketIDToUpdate = scanner.nextLine();
                    ticketDao.updateTicket(ticketIDToUpdate);
                    break;
                case 4:
                    System.out.println("You selected to delete a ticket.");
                    scanner = new Scanner(System.in);
                    System.out.println("Please enter the ticket ID: ");
                    String ticketIDToDelete = scanner.nextLine();
                    ticketDao.deleteTicket(ticketIDToDelete);
                    break;
                case 5:
                    System.out.println("You selected to exit the Service, thank you for using StreamlineIT.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }

            System.out.println("Would you like to perform another function?");

        }

    }

    private int welcome() {

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the StreamlinedIT Service Ticket System. Please select an option:\n" +
                "1: Create a new ticket\n" +
                "2: View an existing ticket\n" +
                "3: Update an existing ticket\n" +
                "4: Delete an existing ticket\n" +
                "5: Exit");

        if(scanner.hasNextInt()){
            choice = scanner.nextInt();
        }else{
            useAttempts++;
            if(useAttempts == 3){
                System.out.println("You have exceeded the number of attempts. Please try again later.");
                System.exit(0);
            }
            System.out.println("Invalid input, please try again.");
            choice = welcome();
        }

        return choice;
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        ServiceUser user = userDao.readUser(username);
        if (user != null) {
            if (user.getUserPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful.");
            } else {
                System.out.println("Incorrect password, please try again.");
                login();
            }
        } else {
            System.out.println("User does not exist, please try again.");
            login();
        }
    }

    private void createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter a password: ");
        String password = scanner.nextLine();
        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your email address: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        ServiceUser user = userDao.createUser(username, password, firstName, lastName, email, phoneNumber);
        System.out.println("Your account will be created with the following information:\n" +
                "User ID: " + user.getUserID() + "\n" +
                "Username: " + user.getUserName() + "\n" +
                "Password: " + user.getUserPassword() + "\n" +
                "First Name: " + user.getUserFirstName() + "\n" +
                "Last Name: " + user.getUserLastName() + "\n" +
                "Email: " + user.getUserEmailAddress() + "\n" +
                "Phone Number: " + user.getUserPhoneNumber());
        System.out.println("Thank you for using the StreamlinedIT system. Your account has been created.");
    }
}
