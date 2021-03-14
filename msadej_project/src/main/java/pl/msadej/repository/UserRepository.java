package pl.msadej.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.msadej.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
