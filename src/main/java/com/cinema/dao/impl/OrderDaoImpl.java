package com.cinema.dao.impl;

import com.cinema.dao.OrderDao;
import com.cinema.exceptions.DataProcessingException;
import com.cinema.lib.Dao;
import com.cinema.model.Order;
import com.cinema.model.User;
import com.cinema.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = cb.createQuery(Order.class);
            Root<Order> orderRoot = criteriaQuery.from(Order.class);
            criteriaQuery.select(orderRoot)
                    .where(cb.equal(orderRoot.get("user"), user));
            orderRoot.fetch("tickets", JoinType.LEFT);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving orders by user.", e);
        }
    }
}
