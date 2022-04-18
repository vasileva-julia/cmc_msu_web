package dao;

import models.GenericModel;
import java.util.Collection;

public interface GenericDAO <T extends GenericModel<ID>, ID extends Number> {
    public void add(T model);
    public void addAll(Collection<T> models);
    public void update(T model);
    public void delete(T model);
    public T getById(ID id);
    public Collection<T> getAll();
}