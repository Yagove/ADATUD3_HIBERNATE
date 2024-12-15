package org.example;

import entities.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

class TicketDAO {
    public List<Ticket> getTicketsByUserId(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket WHERE user.id = :userId", Ticket.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        }
    }

    public List<Ticket> getTicketsByAttractionName(String attractionName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket WHERE attractionName = :attractionName", Ticket.class);
            query.setParameter("attractionName", attractionName);
            return query.getResultList();
        }
    }

    public double getAverageSpendingByUserId(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Double> query = session.createQuery("SELECT AVG(price) FROM Ticket WHERE user.id = :userId", Double.class);
            query.setParameter("userId", userId);
            return query.uniqueResult();
        }
    }
}
