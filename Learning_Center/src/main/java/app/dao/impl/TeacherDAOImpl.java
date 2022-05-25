package app.dao.impl;

import app.dao.TeacherDAO;
import app.models.Course;
import app.models.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;


public class TeacherDAOImpl extends GenericDAOImpl<Teacher, Long> implements TeacherDAO {

    public TeacherDAOImpl(){
        super(Teacher.class);
    }

    @Override
    public List<Teacher> getByCourseName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
        Metamodel m = session.getMetamodel();
        EntityType<Teacher> Teacher_ = m.entity(Teacher.class);
        Root<Teacher> teacher = cq.from(Teacher_);
        Join<Teacher, Course> course = teacher.join("courses");
        cq.select(teacher).where(cb.like(course.get("name"), name));
        Query<Teacher> query = session.createQuery(cq);
        List<Teacher> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
