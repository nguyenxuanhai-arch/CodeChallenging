package com.codechallenge.problem.problem_service.services;

import com.codechallenge.problem.problem_service.dtos.ProblemCreateRequest;
import com.codechallenge.problem.problem_service.dtos.ProblemResponse;
import com.codechallenge.problem.problem_service.dtos.ProblemUpdateRequest;
import com.codechallenge.problem.problem_service.entities.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProblemService {

    Page<ProblemResponse> getAllProblems(Pageable pageable);

    Page<ProblemResponse> searchProblems(String keyword, Pageable pageable);

    Page<ProblemResponse> filterProblems(Problem.Difficulty difficulty, String category, Pageable pageable);

    ProblemResponse getProblemById(Long id);

    ProblemResponse createProblem(ProblemCreateRequest request, Long createdBy);

    ProblemResponse updateProblem(Long id, ProblemUpdateRequest request);

    void deleteProblem(Long id);
}
