package com.codechallenge.problem.problem_service.services;

import com.codechallenge.problem.problem_service.dtos.ProblemCreateRequest;
import com.codechallenge.problem.problem_service.dtos.ProblemResponse;
import com.codechallenge.problem.problem_service.dtos.ProblemUpdateRequest;
import com.codechallenge.problem.problem_service.entities.Problem;
import com.codechallenge.problem.problem_service.exceptions.ProblemNotFoundException;
import com.codechallenge.problem.problem_service.repositories.ProblemRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;

    @Override
    public Page<ProblemResponse> getAllProblems(Pageable pageable) {
        return problemRepository.findAll(pageable).map(ProblemResponse::fromEntity);
    }

    @Override
    public Page<ProblemResponse> searchProblems(String keyword, Pageable pageable) {
        return problemRepository.searchByKeyword(keyword, pageable).map(ProblemResponse::fromEntity);
    }

    @Override
    public Page<ProblemResponse> filterProblems(Problem.Difficulty difficulty, String category, Pageable pageable) {
        return problemRepository.findByFilters(difficulty, category, pageable).map(ProblemResponse::fromEntity);
    }

    @Override
    public ProblemResponse getProblemById(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ProblemNotFoundException(id));
        return ProblemResponse.fromEntity(problem);
    }

    @Override
    @Transactional
    public ProblemResponse createProblem(ProblemCreateRequest request, Long createdBy) {
        Problem problem = new Problem();
        problem.setTitle(request.getTitle());
        problem.setDescription(request.getDescription());
        problem.setDifficulty(request.getDifficulty());
        problem.setTimeLimit(request.getTimeLimit());
        problem.setMemoryLimit(request.getMemoryLimit());
        problem.setTags(request.getTags() != null ? String.join(",", request.getTags()) : null);
        problem.setCategory(request.getCategory());
        problem.setCreatedBy(createdBy);

        Problem savedProblem = problemRepository.save(problem);
        return ProblemResponse.fromEntity(savedProblem);
    }

    @Override
    @Transactional
    public ProblemResponse updateProblem(Long id, ProblemUpdateRequest request) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ProblemNotFoundException(id));

        if (request.getTitle() != null) {
            problem.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            problem.setDescription(request.getDescription());
        }
        if (request.getDifficulty() != null) {
            problem.setDifficulty(request.getDifficulty());
        }
        if (request.getTimeLimit() != null) {
            problem.setTimeLimit(request.getTimeLimit());
        }
        if (request.getMemoryLimit() != null) {
            problem.setMemoryLimit(request.getMemoryLimit());
        }
        if (request.getTags() != null) {
            problem.setTags(String.join(",", request.getTags()));
        }
        if (request.getCategory() != null) {
            problem.setCategory(request.getCategory());
        }

        Problem updatedProblem = problemRepository.save(problem);
        return ProblemResponse.fromEntity(updatedProblem);
    }

    @Override
    @Transactional
    public void deleteProblem(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ProblemNotFoundException(id));
        problemRepository.delete(problem);
    }
}
