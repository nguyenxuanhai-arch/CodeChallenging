package com.codechallenge.problem.problem_service.controllers;

import com.codechallenge.problem.problem_service.dtos.TestCaseCreateRequest;
import com.codechallenge.problem.problem_service.dtos.TestCaseResponse;
import com.codechallenge.problem.problem_service.dtos.TestCaseUpdateRequest;
import com.codechallenge.problem.problem_service.services.TestCaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
public class TestCaseController {

    private final TestCaseService testCaseService;

    @GetMapping("/{problemId}/test-cases")
    public ResponseEntity<List<TestCaseResponse>> getTestCases(
            @PathVariable Long problemId,
            @RequestAttribute(value = "userRole", required = false) String userRole) {
        boolean publicOnly = userRole == null || !userRole.equals("ADMIN");
        List<TestCaseResponse> testCases = testCaseService.getTestCasesByProblemId(problemId, publicOnly);
        return ResponseEntity.ok(testCases);
    }

    @PostMapping("/{problemId}/test-cases")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TestCaseResponse> createTestCase(
            @PathVariable Long problemId,
            @Valid @RequestBody TestCaseCreateRequest request) {
        TestCaseResponse testCase = testCaseService.createTestCase(problemId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(testCase);
    }

    @PutMapping("/test-cases/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TestCaseResponse> updateTestCase(
            @PathVariable Long id,
            @Valid @RequestBody TestCaseUpdateRequest request) {
        TestCaseResponse testCase = testCaseService.updateTestCase(id, request);
        return ResponseEntity.ok(testCase);
    }

    @DeleteMapping("/test-cases/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }
}
