package com.codechallenge.problem.problem_service.repositories;

import com.codechallenge.problem.problem_service.entities.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

    Page<Problem> findAll(Pageable pageable);

    @Query("SELECT p FROM Problem p WHERE " +
           "(:difficulty IS NULL OR p.difficulty = :difficulty) AND " +
           "(:category IS NULL OR p.category = :category)")
    Page<Problem> findByFilters(
            @Param("difficulty") Problem.Difficulty difficulty,
            @Param("category") String category,
            Pageable pageable
    );

    @Query("SELECT p FROM Problem p WHERE " +
           "LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Problem> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
