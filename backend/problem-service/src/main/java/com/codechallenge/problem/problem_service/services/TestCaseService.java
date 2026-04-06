package com.codechallenge.problem.problem_service.services;

import com.codechallenge.problem.problem_service.dtos.TestCaseCreateRequest;
import com.codechallenge.problem.problem_service.dtos.TestCaseResponse;
import com.codechallenge.problem.problem_service.dtos.TestCaseUpdateRequest;

import java.util.List;

public interface TestCaseService {

    List<TestCaseResponse> getTestCasesByProblemId(Long problemId, boolean publicOnly);

    TestCaseResponse createTestCase(Long problemId, TestCaseCreateRequest request);

    TestCaseResponse updateTestCase(Long id, TestCaseUpdateRequest request);

    void deleteTestCase(Long id);
}
