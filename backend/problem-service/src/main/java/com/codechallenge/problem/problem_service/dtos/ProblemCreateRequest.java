package com.codechallenge.problem.problem_service.dtos;

import com.codechallenge.problem.problem_service.entities.Problem;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemCreateRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must be less than 200 characters")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Difficulty is required")
    private Problem.Difficulty difficulty;

    @NotNull(message = "Time limit is required")
    @Min(value = 100, message = "Time limit must be at least 100ms")
    @Max(value = 60000, message = "Time limit must be at most 60000ms")
    private Integer timeLimit;

    @NotNull(message = "Memory limit is required")
    @Min(value = 16, message = "Memory limit must be at least 16MB")
    @Max(value = 512, message = "Memory limit must be at most 512MB")
    private Integer memoryLimit;

    private List<String> tags;

    @Size(max = 100, message = "Category must be less than 100 characters")
    private String category;
}
