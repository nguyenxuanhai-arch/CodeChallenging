package com.codechallenge.problem.problem_service.dtos;

import com.codechallenge.problem.problem_service.entities.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseResponse {
    private Long id;
    private Long problemId;
    private String input;
    private String expectedOutput;
    private Boolean isPublic;
    private Integer orderIndex;

    public static TestCaseResponse fromEntity(TestCase testCase) {
        TestCaseResponse response = new TestCaseResponse();
        response.setId(testCase.getId());
        response.setProblemId(testCase.getProblem().getId());
        response.setInput(testCase.getInput());
        response.setExpectedOutput(testCase.getExpectedOutput());
        response.setIsPublic(testCase.getIsPublic());
        response.setOrderIndex(testCase.getOrderIndex());
        return response;
    }

    public static TestCaseResponse fromEntityPublicOnly(TestCase testCase) {
        TestCaseResponse response = new TestCaseResponse();
        response.setId(testCase.getId());
        response.setProblemId(testCase.getProblem().getId());
        response.setInput(testCase.getInput());
        response.setExpectedOutput(testCase.getExpectedOutput());
        response.setIsPublic(testCase.getIsPublic());
        response.setOrderIndex(testCase.getOrderIndex());
        return response;
    }
}
