package com.Fyndus.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fyndus.entity.Result;
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

}
