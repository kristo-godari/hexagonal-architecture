package org.godari.hexagonalarchitecture.adapter.out.externalusers.client;

import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(
        url = "/api",
        accept = MediaType.APPLICATION_JSON_VALUE)
public interface ReqResClient {

    @GetExchange("/users")
    UsersResponse getAllUsers();

}