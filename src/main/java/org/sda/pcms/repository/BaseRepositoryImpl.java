package org.sda.pcms.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.sda.pcms.repository.exception.EntityCreationFailedException;
import org.sda.pcms.repository.exception.EntityDeletionFailedException;
import org.sda.pcms.repository.exception.EntityFetchingFailedException;
import org.sda.pcms.repository.exception.EntityUpdateFailedException;
import org.sda.pcms.utils.SessionManager;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<T> implements BaseRepository<T> {
    private final Class<T> entityClass;

    public BaseRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(entity);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EntityCreationFailedException(
                    "Entity creation failed!", e
            );
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(entity);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EntityUpdateFailedException(
                    "Entity update failed!", e
            );
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(entity);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EntityDeletionFailedException(
                    "Entity deletion failed!", e
            );
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<T> query = session.createQuery(
                    "from " + entityClass.getSimpleName(), entityClass
            );
            return query.list();
        } catch (Exception e) {
            throw new EntityFetchingFailedException(
                    "Failed to load all entities!", e
            );
        }
    }

    @Override
    public Optional<T> findById(int id) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.find(entityClass,id));
        } catch (Exception e) {
            throw new EntityFetchingFailedException(
                    "Failed to load entity by id!", e
            );
        }
    }
}
