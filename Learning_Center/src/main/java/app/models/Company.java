package app.models;

import lombok.*;
import java.util.HashSet;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"teachers"})
@Table(name = "company")
public class Company implements GenericModel<Long> {

    public Company() {}

    public Company(String name, String address, Set<Teacher> teachers) {
        this.name = name;
        this.address = address;
        this.teachers = teachers;
    }

    public Company(Long id, String name, String address, Set<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.teachers = teachers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "address", length = 50, nullable = true)
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Teacher> teachers = new HashSet<Teacher>(0);

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Company other = (Company) obj;
        return (this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
