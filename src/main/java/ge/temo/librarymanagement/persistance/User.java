package ge.temo.librarymanagement.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
@SequenceGenerator(name = "app_user_seq_gen", sequenceName = "app_user_seq", allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(generator = "app_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
