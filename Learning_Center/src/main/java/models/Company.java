package models;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    private Long id;
    private String name;
    private String address;
    private Set<Teacher> teachers = new HashSet<Teacher>(0);

    public Company() {
    }

    public Company(String name, String address, Set<Teacher> teachers) {
        this.name = name;
        this.address = address;
        this.teachers = teachers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    public Long getId() {
        return  this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", length = 50, nullable = true)
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Teacher> getTeachers() {
        return this.teachers;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Company other = (Company) obj;
        return Objects.equals(id, other.id)
                && name.equals(other.name)
                && address.equals(other.address);
    }
}
