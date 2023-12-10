package org.godari.hexagonalarchitecture.adapter.out.externalusers.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UsersResponse(
   Integer page,
   @JsonProperty("per_page")
   Integer perPage,
   Integer total,
   @JsonProperty("total_pages")
   Integer totalPages,
   @JsonProperty("data")
   List<UserData> userData
) {}
