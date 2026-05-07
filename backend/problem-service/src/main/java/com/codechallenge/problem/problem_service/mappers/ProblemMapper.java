package com.codechallenge.problem.problem_service.mappers;

import com.codechallenge.problem.problem_service.dtos.ProblemCreateRequest;
import com.codechallenge.problem.problem_service.dtos.ProblemResponse;
import com.codechallenge.problem.problem_service.dtos.ProblemUpdateRequest;
import com.codechallenge.problem.problem_service.entities.Problem;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ProblemMapper {
    Problem toEntity(ProblemCreateRequest request);
    ProblemResponse toResponse(Problem problem);

    default Page<ProblemResponse> toPageResponse(Page<Problem> page) {
        return page.map(this::toResponse);
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(ProblemUpdateRequest request,@MappingTarget Problem problem);
}
