package models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Objects;
import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@ToString(exclude = {"courses"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "teacher_id", unique = true, nullable = false)
    private Long id;

    @NonNull
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "login")
    private String login;

    @NonNull
    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Course> courses = new HashSet<>(0);

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Teacher other = (Teacher) obj;
        return Objects.equals(id, other.id)
                && name.equals(other.name)
                && login.equals(other.login)
                && password.equals(other.password);
    }
}
