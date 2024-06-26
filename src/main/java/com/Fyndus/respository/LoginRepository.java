package com.Fyndus.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fyndus.entity.Login;
import com.example.demo.Entity.User;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	Optional<User> findByEmail(String email);

}
