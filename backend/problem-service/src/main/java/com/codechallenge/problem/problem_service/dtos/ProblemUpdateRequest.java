package com.codechallenge.problem.problem_service.dtos;

import com.codechallenge.problem.problem_service.entities.Problem;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemUpdateRequest {

    @Size(max = 200, message = "Title must be less than 200 characters")
    private String title;

    private String description;

    private Problem.Difficulty difficulty;

    @Min(value = 100, message = "Time limit must be at least 100ms")
    @Max(value = 60000, message = "Time limit must be at most 60000ms")
    private Integer timeLimit;

    @Min(value = 16, message = "Memory limit must be at least 16MB")
    @Max(value = 512, message = "Memory limit must be at most 512MB")
    private Integer memoryLimit;

    private List<String> tags;

    @Size(max = 100, message = "Category must be less than 100 characters")
    private String category;
}
