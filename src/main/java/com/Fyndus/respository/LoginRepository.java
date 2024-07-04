package com.Fyndus.respository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Fyndus.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	Optional<Login> findByEmail(String email);

    List<Login> findByemail(String email);

}
