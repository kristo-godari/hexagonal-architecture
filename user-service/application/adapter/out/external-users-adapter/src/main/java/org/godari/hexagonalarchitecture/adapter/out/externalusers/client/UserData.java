package org.godari.hexagonalarchitecture.adapter.out.externalusers.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserData(
        Long id,
        String email,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        String avatar
) {}
