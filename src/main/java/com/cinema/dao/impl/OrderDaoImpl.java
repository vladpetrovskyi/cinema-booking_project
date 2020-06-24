package com.cinema.dao.impl;

import com.cinema.dao.OrderDao;
import com.cinema.exceptions.DataProcessingException;
import com.cinema.model.Order;
import com.cinema.model.User;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderDaoImpl implements OrderDao {

    private final SessionFactory sessionFactory;

    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not insert Order entity.", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> findByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = cb.createQuery(Order.class);
            Root<Order> orderRoot = criteriaQuery.from(Order.class);
            orderRoot.fetch("tickets", JoinType.LEFT);
            return session.createQuery(criteriaQuery.distinct(true)
                    .select(orderRoot).where(cb.equal(orderRoot.get("user"), user)))
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving orders by user.", e);
        }
    }
}
