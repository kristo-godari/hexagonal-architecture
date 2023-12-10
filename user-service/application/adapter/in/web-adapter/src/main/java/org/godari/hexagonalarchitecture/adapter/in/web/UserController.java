package org.godari.hexagonalarchitecture.adapter.in.web;

import org.godari.hexagonalarchitecture.common.domain.User;
import org.godari.hexagonalarchitecture.common.domain.UserCreateRequest;
import org.godari.hexagonalarchitecture.port.in.UserUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public Boolean createUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = new User(userCreateRequest.firstName(), userCreateRequest.lastName());
        return userUseCase.create(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userUseCase.get(id);
    }

    @GetMapping()
    public List<User> getUsers() {
        return userUseCase.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable String id) {
       return userUseCase.delete(id);
    }
}
