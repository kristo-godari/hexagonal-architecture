package org.godari.hexagonalarchitecture.port.out;

import org.godari.hexagonalarchitecture.common.domain.User;

import java.util.List;

public interface PersistencePort {

    Boolean saveUser(User user);

    User getUser(String userId);

    Boolean deleteUser(String userId);

    List<User> getAllUsers();
}
