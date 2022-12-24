package dians.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "korisnici")
public class User {
    @Id
    private String username;

    private String name;

    private String email;

    private String password;

    public User(String username, String password, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
