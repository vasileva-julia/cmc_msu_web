package dao.impl;

import dao.StudentDAO;
import models.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;


public class StudentDAOImpl extends GenericDAOImpl<Student, Long> implements StudentDAO {

    public StudentDAOImpl() { super(Student.class); }

    @Override
    public List<Student> getByCourseId(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Metamodel m = session.getMetamodel();
        EntityType<Student> Student_ = m.entity(Student.class);
        Root<Student> student = cq.from(Student_);
        Join<Student, Course> course = student.join("courses");
        cq.select(student).where(cb.equal(course.get("id"), id));
        Query<Student> query = session.createQuery(cq);
        List<Student> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
