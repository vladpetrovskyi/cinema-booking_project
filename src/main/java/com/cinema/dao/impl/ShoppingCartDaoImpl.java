package com.cinema.dao.impl;

import com.cinema.dao.ShoppingCartDao;
import com.cinema.exceptions.DataProcessingException;
import com.cinema.model.ShoppingCart;
import com.cinema.model.User;
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
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    private final SessionFactory sessionFactory;

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
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
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ShoppingCart> criteriaQuery = cb.createQuery(ShoppingCart.class);
            Root<ShoppingCart> shoppingCartRoot = criteriaQuery.from(ShoppingCart.class);
            criteriaQuery.select(shoppingCartRoot)
                    .where(cb.equal(shoppingCartRoot.get("user"), user));
            shoppingCartRoot.fetch("tickets", JoinType.LEFT);
            return session.createQuery(criteriaQuery).uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving shopping cart by user.", e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
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
