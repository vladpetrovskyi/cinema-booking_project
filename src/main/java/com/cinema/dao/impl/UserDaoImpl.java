package com.cinema.dao.impl;

import com.cinema.dao.UserDao;
import com.cinema.exceptions.DataProcessingException;
import com.cinema.model.User;
import java.util.Optional;
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
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
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
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            userRoot.fetch("roles", JoinType.LEFT);
            return session.createQuery(
                    criteriaQuery.distinct(true)
                            .select(userRoot)
                            .where(cb.equal(userRoot.get("email"), email)))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving user by email.", e);
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            root.fetch("roles", JoinType.LEFT);
            return session.createQuery(
                    criteriaQuery.distinct(true)
                            .select(root)
                            .where(cb.equal(root.get("id"), id)))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving user by ID.", e);
        }
    }
}
