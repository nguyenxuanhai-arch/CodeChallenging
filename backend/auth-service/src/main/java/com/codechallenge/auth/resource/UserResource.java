package com.codechallenge.auth.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResource {
    private final Long id;
    private final String email;
    private final String name;
    private final String phone;
    private final String address;
    private final Long userCatalogueId;
}