package com.codechallenge.problem.problem_service.services.impl;

import com.codechallenge.problem.problem_service.dtos.ProblemCreateRequest;
import com.codechallenge.problem.problem_service.dtos.ProblemResponse;
import com.codechallenge.problem.problem_service.dtos.ProblemUpdateRequest;
import com.codechallenge.problem.problem_service.entities.Problem;
import com.codechallenge.problem.problem_service.exceptions.ProblemNotFoundException;
import com.codechallenge.problem.problem_service.mappers.ProblemMapper;
import com.codechallenge.problem.problem_service.repositories.ProblemRepository;

import com.codechallenge.problem.problem_service.services.interfaces.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;

    @Override
    public Page<ProblemResponse> getAllProblems(Pageable pageable) {
        return problemMapper.toPageResponse(problemRepository.findAll(pageable));
    }

    @Override
    public Page<ProblemResponse> searchProblems(String keyword, Pageable pageable) {
        return problemMapper.toPageResponse(problemRepository.searchByKeyword(keyword, pageable));
    }

    @Override
    public Page<ProblemResponse> filterProblems(Problem.Difficulty difficulty, String category, Pageable pageable) {
        return problemMapper.toPageResponse(problemRepository.findByFilters(difficulty, category, pageable));
    }

    @Override
    public ProblemResponse getProblemById(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ProblemNotFoundException(id));
        return problemMapper.toResponse(problem);
    }

    @Override
    @Transactional
    public ProblemResponse createProblem(ProblemCreateRequest request, Long createdBy) {
        Problem problem = problemMapper.toEntity(request);
        problem.setCreatedBy(createdBy);

        Problem savedProblem = problemRepository.save(problem);
        return problemMapper.toResponse(savedProblem);
    }

    @Override
    @Transactional
    public ProblemResponse updateProblem(Long id, ProblemUpdateRequest request) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ProblemNotFoundException(id));

        problemMapper.updateEntityFromRequest(request, problem);
        return problemMapper.toResponse(problem);
    }

    @Override
    @Transactional
    public void deleteProblem(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ProblemNotFoundException(id));
        problemRepository.delete(problem);
    }
}
