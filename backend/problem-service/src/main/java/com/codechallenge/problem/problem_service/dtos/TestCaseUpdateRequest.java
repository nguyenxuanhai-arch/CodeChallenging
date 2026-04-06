package com.codechallenge.problem.problem_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseUpdateRequest {
    private String input;
    private String expectedOutput;
    private Boolean isPublic;
    private Integer orderIndex;
}
