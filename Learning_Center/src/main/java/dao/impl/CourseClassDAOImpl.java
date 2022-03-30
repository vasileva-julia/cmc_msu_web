package dao.impl;

import dao.CourseClassDAO;
import models.Course;
import models.CourseClass;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateSessionFactoryUtil;
import java.util.List;


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

    @Override
    public CourseClass getByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<CourseClass> query = session.createQuery("from CourseClass where id = :id_param", CourseClass.class);
        query.setParameter("id_param", id);
        List<CourseClass> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        if (result.size() == 0)
            return null;
        return (CourseClass) result.get(0);
    }

    @Override
    public List<CourseClass> getByCourse(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<CourseClass> query = session.createQuery("from CourseClass where course = :course_param", CourseClass.class);
        query.setParameter("course_param", course);
        return query.getResultList();
    }

}
