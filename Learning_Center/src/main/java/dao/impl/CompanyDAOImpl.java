package dao.impl;

import dao.CompanyDAO;
import models.Company;
import org.hibernate.Session;
import util.HibernateSessionFactoryUtil;

public class CompanyDAOImpl implements CompanyDAO {

    @Override
    public void add(Company company) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("AdminCreate Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void update(Company company) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("AdminUpdate Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void delete(Company company) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("AdminDelete Exception thrown: " + e.getMessage());
        }
    }
}
