package main;

import main.controllers.Controller;

public class App {

     private static Startup startup;
     private static Controller controller;

     public static void main(String[] args) {
          startup = new Startup();
          startup.getUserDao();
          startup.getTicketDao();
          controller = startup.getController();
          controller.Start();
     }

}
