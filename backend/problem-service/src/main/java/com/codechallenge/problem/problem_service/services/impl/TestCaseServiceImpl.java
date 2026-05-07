package com.codechallenge.problem.problem_service.services.impl;

import com.codechallenge.problem.problem_service.dtos.TestCaseCreateRequest;
import com.codechallenge.problem.problem_service.dtos.TestCaseResponse;
import com.codechallenge.problem.problem_service.dtos.TestCaseUpdateRequest;
import com.codechallenge.problem.problem_service.entities.Problem;
import com.codechallenge.problem.problem_service.entities.TestCase;
import com.codechallenge.problem.problem_service.exceptions.ProblemNotFoundException;
import com.codechallenge.problem.problem_service.exceptions.TestCaseNotFoundException;
import com.codechallenge.problem.problem_service.mappers.TestCaseMapper;
import com.codechallenge.problem.problem_service.repositories.ProblemRepository;
import com.codechallenge.problem.problem_service.repositories.TestCaseRepository;

import com.codechallenge.problem.problem_service.services.interfaces.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository testCaseRepository;
    private final ProblemRepository problemRepository;
    private final TestCaseMapper testCaseMapper;

    @Override
    public List<TestCaseResponse> getTestCasesByProblemId(Long problemId, boolean publicOnly) {
        List<TestCase> testCases = publicOnly
                ? testCaseRepository.findByProblemIdAndIsPublicTrueOrderByOrderIndexAsc(problemId)
                : testCaseRepository.findByProblemIdOrderByOrderIndexAsc(problemId);

        return testCaseMapper.toResponseList(testCases);
    }

    @Override
    @Transactional
    public TestCaseResponse createTestCase(Long problemId, TestCaseCreateRequest request) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> new ProblemNotFoundException(problemId));

        TestCase testCase = testCaseMapper.toEntity(request);
        testCase.setProblem(problem);

        testCaseRepository.save(testCase);
        return testCaseMapper.toResponse(testCase);
    }

    @Override
    @Transactional
    public TestCaseResponse updateTestCase(Long id, TestCaseUpdateRequest request) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException(id));

        testCaseMapper.updateEntityFromRequest(request, testCase);

        return testCaseMapper.toResponse(testCase);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException(id));
        testCaseRepository.delete(testCase);
    }
}
