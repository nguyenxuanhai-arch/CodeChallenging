package com.codechallenge.problem.problem_service.mappers;

import com.codechallenge.problem.problem_service.dtos.TestCaseCreateRequest;
import com.codechallenge.problem.problem_service.dtos.TestCaseResponse;
import com.codechallenge.problem.problem_service.dtos.TestCaseUpdateRequest;
import com.codechallenge.problem.problem_service.entities.TestCase;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestCaseMapper {
    @Mapping(target = "orderIndex", source = "orderIndex", defaultValue = "0")
    @Mapping(target = "isPublic", source = "isPublic", defaultValue = "false")
    TestCase toEntity(TestCaseCreateRequest testCaseCreateRequest);

    TestCaseResponse toResponse(TestCase testCase);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(TestCaseUpdateRequest request, @MappingTarget TestCase testCase);

    List<TestCaseResponse> toResponseList(List<TestCase> testCases);
}
