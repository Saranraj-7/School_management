package com.Fyndus.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fyndus.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
