package dians.finki.ukim.mk.lab.repository;

import dians.finki.ukim.mk.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByEmail(String email);

    User findAllByUsername(String username);
}
