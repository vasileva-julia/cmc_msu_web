package dao.impl;

import dao.CourseClassDAO;
import models.CourseClass;
import org.hibernate.Session;
import util.HibernateSessionFactoryUtil;


public class CourseClassDAOImpl implements CourseClassDAO {

    @Override
    public void add(CourseClass courseClass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(courseClass);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(CourseClass courseClass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(courseClass);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(CourseClass courseClass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(courseClass);
        session.getTransaction().commit();
        session.close();
    }
}
