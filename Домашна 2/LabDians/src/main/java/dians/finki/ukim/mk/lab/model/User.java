package dians.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private Long id;

    private String username;

    private String name;

    private String email;

    private String password;

    public User(Long id, String username, String name, String email, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
