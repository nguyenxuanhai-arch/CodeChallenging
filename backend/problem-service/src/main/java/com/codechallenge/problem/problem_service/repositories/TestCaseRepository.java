package com.codechallenge.problem.problem_service.repositories;

import com.codechallenge.problem.problem_service.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findByProblemIdOrderByOrderIndexAsc(Long problemId);

    List<TestCase> findByProblemIdAndIsPublicTrueOrderByOrderIndexAsc(Long problemId);
}
