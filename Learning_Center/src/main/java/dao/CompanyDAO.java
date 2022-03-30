package dao;

import models.Company;
import models.Teacher;
import java.util.List;

public interface CompanyDAO {
    public void add(Company company);
    public void update(Company company);
    public void delete(Company company);
    public Company getByID(Long id);
    public List<Company> getByTeacher(Teacher teacher);
}
