package com.codechallenge.problem.problem_service.dtos;

import com.codechallenge.problem.problem_service.entities.Problem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemResponse {
    private Long id;
    private String title;
    private String description;
    private Problem.Difficulty difficulty;
    private Integer timeLimit;
    private Integer memoryLimit;
    private List<String> tags;
    private String category;
    private Long createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer totalTestCases;
    private Integer publicTestCases;

    public static ProblemResponse fromEntity(Problem problem) {
        ProblemResponse response = new ProblemResponse();
        response.setId(problem.getId());
        response.setTitle(problem.getTitle());
        response.setDescription(problem.getDescription());
        response.setDifficulty(problem.getDifficulty());
        response.setTimeLimit(problem.getTimeLimit());
        response.setMemoryLimit(problem.getMemoryLimit());
        response.setTags(problem.getTags() != null ? List.of(problem.getTags().split(",")) : List.of());
        response.setCategory(problem.getCategory());
        response.setCreatedBy(problem.getCreatedBy());
        response.setCreatedAt(problem.getCreatedAt());
        response.setUpdatedAt(problem.getUpdatedAt());
        response.setTotalTestCases(problem.getTestCases().size());
        response.setPublicTestCases((int) problem.getTestCases().stream().filter(tc -> tc.getIsPublic()).count());
        return response;
    }
}
