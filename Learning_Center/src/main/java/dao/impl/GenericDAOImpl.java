package dao.impl;

import dao.GenericDAO;
import models.GenericModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSessionFactoryUtil;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;


public class GenericDAOImpl <T extends GenericModel<ID>, ID extends Number> implements GenericDAO<T, ID> {

    protected SessionFactory sessionFactory;
    protected Class<T> persistentClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.persistentClass = entityClass;
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public void add(T model) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T getById(ID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T model = session.get(persistentClass, id);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    @Override
    public Collection<T> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(persistentClass);
        criteriaQuery.from(persistentClass);
        Collection<T> resul = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();
        return resul;
    }

    @Override
    public void addAll(Collection<T> models) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (T model : models) {
            session.save(model);
        }
        session.getTransaction().commit();
    }

    @Override
    public void update(T model) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T model) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }
}


