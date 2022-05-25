package app.dao;

import app.models.Company;
import java.util.List;

public interface CompanyDAO extends GenericDAO<Company, Long>  {
    public List<Company> getByTeacherId(Long id);
}
