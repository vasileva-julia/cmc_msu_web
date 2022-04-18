package dao;

import models.Company;
import java.util.List;

public interface CompanyDAO extends GenericDAO<Company, Long>  {
    public List<Company> getByTeacherId(Long id);
}
