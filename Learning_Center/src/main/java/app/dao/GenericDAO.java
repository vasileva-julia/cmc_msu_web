package app.dao;

import app.models.GenericModel;
import java.util.Collection;

public interface GenericDAO <T extends GenericModel<ID>, ID extends Number> {
    void add(T model);
    void addAll(Collection<T> models);
    void update(T model);
    void delete(T model);
    T getById(ID id);
    Collection<T> getAll();
}