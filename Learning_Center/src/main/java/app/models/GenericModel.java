package app.models;

public interface GenericModel<ID> {
    ID getId();
    void setId(ID id);
}
