package com.metropolitan.repository;

import com.metropolitan.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
}
