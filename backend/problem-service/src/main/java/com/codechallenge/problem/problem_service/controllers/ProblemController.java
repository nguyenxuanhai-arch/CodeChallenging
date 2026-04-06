package com.codechallenge.problem.problem_service.controllers;

import com.codechallenge.problem.problem_service.dtos.ProblemCreateRequest;
import com.codechallenge.problem.problem_service.dtos.ProblemResponse;
import com.codechallenge.problem.problem_service.dtos.ProblemUpdateRequest;
import com.codechallenge.problem.problem_service.entities.Problem;
import com.codechallenge.problem.problem_service.services.ProblemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping
    public ResponseEntity<Page<ProblemResponse>> getAllProblems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProblemResponse> problems = problemService.getAllProblems(pageable);
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProblemResponse>> searchProblems(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProblemResponse> problems = problemService.searchProblems(keyword, pageable);
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<ProblemResponse>> filterProblems(
            @RequestParam(required = false) Problem.Difficulty difficulty,
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProblemResponse> problems = problemService.filterProblems(difficulty, category, pageable);
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProblemResponse> getProblemById(@PathVariable Long id) {
        ProblemResponse problem = problemService.getProblemById(id);
        return ResponseEntity.ok(problem);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProblemResponse> createProblem(
            @Valid @RequestBody ProblemCreateRequest request,
            @RequestAttribute("userId") Long userId) {
        ProblemResponse problem = problemService.createProblem(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(problem);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProblemResponse> updateProblem(
            @PathVariable Long id,
            @Valid @RequestBody ProblemUpdateRequest request) {
        ProblemResponse problem = problemService.updateProblem(id, request);
        return ResponseEntity.ok(problem);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);
        return ResponseEntity.noContent().build();
    }
}
