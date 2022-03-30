package dao;

import models.CourseClass;

public interface CourseClassDAO {
    public void add(CourseClass courseClass);
    public void update(CourseClass courseClass);
    public void delete(CourseClass courseClass);
//    public Set<Class> getAllClasses();
//    public Class getClassById(long id);
//    public Set<Class> getClassesByCourse(Course course);
//    public Class getClassByTheme(String theme);
}
