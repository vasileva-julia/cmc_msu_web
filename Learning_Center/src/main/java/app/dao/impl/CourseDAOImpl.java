package app.dao.impl;

import app.dao.CourseDAO;
import app.models.Course;


public class CourseDAOImpl extends GenericDAOImpl<Course, Integer> implements CourseDAO {
    public CourseDAOImpl(){
        super(Course.class);
    }
}
