package org.godari.hexagonalarchitecture.adapter.in.websocket;

import lombok.AllArgsConstructor;
import org.godari.hexagonalarchitecture.common.domain.User;
import org.godari.hexagonalarchitecture.common.domain.UserCreateRequest;
import org.godari.hexagonalarchitecture.port.in.UserUseCase;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
public class WebSocketController {

    private UserUseCase userUseCase;

    @MessageMapping("/users/create")
    @SendTo("/topic/response")
    public Boolean createUser(UserCreateRequest userCreateRequest) {
        User user = new User(userCreateRequest.firstName(), userCreateRequest.lastName());
        return userUseCase.create(user);
    }

    @MessageMapping("/users/get")
    @SendTo("/topic/response")
    public User getUser(String id) {
        return userUseCase.get(id);
    }

    @MessageMapping("/users/get-all")
    @SendTo("/topic/response")
    public List<User> getUsers() {
        return userUseCase.getAllUsers();
    }

    @MessageMapping("/users/delete")
    @SendTo("/topic/response")
    public Boolean deleteUser(String id) {
        return userUseCase.delete(id);
    }
}