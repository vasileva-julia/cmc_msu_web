package dao.impl;

import dao.TeacherDAO;
import models.Teacher;
import org.hibernate.Session;
import util.HibernateSessionFactoryUtil;

public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public void add(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(teacher);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
    }

}
