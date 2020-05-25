package com.cinema.dao.impl;

import com.cinema.dao.UserDao;
import com.cinema.exceptions.DataProcessingException;
import com.cinema.lib.Dao;
import com.cinema.model.User;
import com.cinema.util.HibernateUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public User add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long userId = (Long) session.save(user);
            transaction.commit();
            user.setId(userId);
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not insert user entity.", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public User findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            criteriaQuery.select(userRoot).where(cb.equal(userRoot.get("email"), email));
            return session.createQuery(criteriaQuery).uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving user by email.", e);
        }
    }
}
