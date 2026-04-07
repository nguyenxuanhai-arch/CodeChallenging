package com.codechallenge.problem.problem_service.exceptions;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(Long id) {
        super("Test case not found with id: " + id);
    }
}
