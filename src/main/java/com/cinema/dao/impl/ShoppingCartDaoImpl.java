package com.cinema.dao.impl;

import com.cinema.dao.ShoppingCartDao;
import com.cinema.exceptions.DataProcessingException;
import com.cinema.lib.Dao;
import com.cinema.model.ShoppingCart;
import com.cinema.model.User;
import com.cinema.util.HibernateUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
            return shoppingCart;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not insert shopping cart entity.", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ShoppingCart> criteriaQuery = cb.createQuery(ShoppingCart.class);
            Root<ShoppingCart> shoppingCartRoot = criteriaQuery.from(ShoppingCart.class);
            criteriaQuery.select(shoppingCartRoot)
                    .where(cb.equal(shoppingCartRoot.get("user"), user));
            ShoppingCart shoppingCart = session.createQuery(criteriaQuery).uniqueResult();
            Hibernate.initialize(shoppingCart.getTickets());
            return shoppingCart;
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving shopping cart by user.", e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not update shopping cart entity.", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
