package dao;

import models.Company;

public interface CompanyDAO {
    public void add(Company company);
    public void update(Company company);
    public void delete(Company company);
//    public Set<Class> getAllClasses();
//    public Class getClassById(long id);
//    public Set<Class> getClassesByCourse(Course course);
//    public Class getClassByTheme(String theme);
}
