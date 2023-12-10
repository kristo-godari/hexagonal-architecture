package org.godari.hexagonalarchitecture.adapter.out.postgres;

import org.godari.hexagonalarchitecture.common.domain.User;
import org.godari.hexagonalarchitecture.port.out.PersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostgresAdapter implements PersistencePort {
    @Override
    public Boolean saveUser(User user) {
        return true;
    }

    @Override
    public User getUser(String userId) {
        return new User("Kristo", "Godari");
    }

    @Override
    public Boolean deleteUser(String userId) {
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of(new User("Kristo", "Godari"));
    }
}
