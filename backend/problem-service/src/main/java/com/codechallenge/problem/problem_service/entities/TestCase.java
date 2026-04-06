package com.codechallenge.problem.problem_service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    @JsonIgnore
    private Problem problem;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String input;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String expectedOutput;

    @Column(nullable = false)
    private Boolean isPublic = false; // Public test cases are visible to users

    @Column(nullable = false)
    private Integer orderIndex = 0; // Order of test case

    public TestCase(Problem problem, String input, String expectedOutput, Boolean isPublic, Integer orderIndex) {
        this.problem = problem;
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.isPublic = isPublic;
        this.orderIndex = orderIndex;
    }
}
