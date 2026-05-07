package com.codechallenge.problem.problem_service.services;

import com.codechallenge.problem.problem_service.dtos.TestCaseCreateRequest;
import com.codechallenge.problem.problem_service.dtos.TestCaseResponse;
import com.codechallenge.problem.problem_service.dtos.TestCaseUpdateRequest;
import com.codechallenge.problem.problem_service.entities.Problem;
import com.codechallenge.problem.problem_service.entities.TestCase;
import com.codechallenge.problem.problem_service.exceptions.ProblemNotFoundException;
import com.codechallenge.problem.problem_service.exceptions.TestCaseNotFoundException;
import com.codechallenge.problem.problem_service.repositories.ProblemRepository;
import com.codechallenge.problem.problem_service.repositories.TestCaseRepository;

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

    @Override
    public List<TestCaseResponse> getTestCasesByProblemId(Long problemId, boolean publicOnly) {
        List<TestCase> testCases = publicOnly
                ? testCaseRepository.findByProblemIdAndIsPublicTrueOrderByOrderIndexAsc(problemId)
                : testCaseRepository.findByProblemIdOrderByOrderIndexAsc(problemId);

        return testCases.stream()
                .map(TestCaseResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TestCaseResponse createTestCase(Long problemId, TestCaseCreateRequest request) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> new ProblemNotFoundException(problemId));

        TestCase testCase = new TestCase();
        testCase.setProblem(problem);
        testCase.setInput(request.getInput());
        testCase.setExpectedOutput(request.getExpectedOutput());
        testCase.setIsPublic(request.getIsPublic());
        testCase.setOrderIndex(request.getOrderIndex() != null ? request.getOrderIndex() : 0);

        TestCase savedTestCase = testCaseRepository.save(testCase);
        return TestCaseResponse.fromEntity(savedTestCase);
    }

    @Override
    @Transactional
    public TestCaseResponse updateTestCase(Long id, TestCaseUpdateRequest request) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException(id));

        if (request.getInput() != null) {
            testCase.setInput(request.getInput());
        }
        if (request.getExpectedOutput() != null) {
            testCase.setExpectedOutput(request.getExpectedOutput());
        }
        if (request.getIsPublic() != null) {
            testCase.setIsPublic(request.getIsPublic());
        }
        if (request.getOrderIndex() != null) {
            testCase.setOrderIndex(request.getOrderIndex());
        }

        TestCase updatedTestCase = testCaseRepository.save(testCase);
        return TestCaseResponse.fromEntity(updatedTestCase);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException(id));
        testCaseRepository.delete(testCase);
    }
}
