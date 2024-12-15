package org.example;

import entities.Ticket;
import entities.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        TicketDAO ticketDAO = new TicketDAO();

        // Crear Usuario
        User user = new User("John Doe");
        userDAO.saveUser(user);

        // Añadir tickets al usuario
        Ticket ticket1 = new Ticket("Roller Coaster", 50.0);
        Ticket ticket2 = new Ticket("Ferris Wheel", 30.0);
        user.addTicket(ticket1);
        user.addTicket(ticket2);
        userDAO.updateUser(user);

        // Buscar y mostrar usuarios
        System.out.println("All Users: " + userDAO.getAllUsers());

        // Buscar y mostrar tickets por el id del usuario
        System.out.println("Tickets for User ID 1: " + ticketDAO.getTicketsByUserId(1));

        // Calcular el gasto promedio por usuario
        System.out.println("Average spending for User ID 1: " + ticketDAO.getAverageSpendingByUserId(1));


    }
}