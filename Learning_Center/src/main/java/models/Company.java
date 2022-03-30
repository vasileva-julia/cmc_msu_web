package models;

import lombok.*;
import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "company")
public class Company {

    public Company() {}

    public Company(String name, String address, Set<Teacher> teachers) {
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

}
