package com.codechallenge.problem.problem_service.exceptions;

public class ProblemNotFoundException extends RuntimeException {
    public ProblemNotFoundException(Long id) {
        super("Problem not found with id: " + id);
    }
}
