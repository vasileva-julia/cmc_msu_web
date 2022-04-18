package dao;

import models.CourseClass;
import java.util.List;

public interface CourseClassDAO extends GenericDAO<CourseClass, Long>  {
    public List<CourseClass> getByCourseName(String name);
}
