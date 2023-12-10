package org.godari.hexagonalarchitecture.domain.service;

import org.godari.hexagonalarchitecture.common.domain.User;
import org.godari.hexagonalarchitecture.port.in.UserUseCase;
import org.godari.hexagonalarchitecture.port.out.ExternalUsersPort;
import org.godari.hexagonalarchitecture.port.out.PersistencePort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserUseCase {

    private final PersistencePort persistencePort;
    private final ExternalUsersPort externalUsersPort;

    public UserService(PersistencePort persistencePort, ExternalUsersPort externalUsersPort) {
        this.persistencePort = persistencePort;
        this.externalUsersPort = externalUsersPort;
    }

    @Override
    public Boolean create(User user) {
        return persistencePort.saveUser(null);
    }

    @Override
    public User get(String userId) {
        return persistencePort.getUser(userId);
    }

    @Override
    public Boolean delete(String userId) {
        return persistencePort.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(persistencePort.getAllUsers());
        allUsers.addAll(externalUsersPort.getUsers());

        return allUsers;
    }

    @Override
    public List<String> cleanupInactiveUsers() {
        return null;
    }
}
