package org.godari.hexagonalarchitecture.port.in;

import org.godari.hexagonalarchitecture.common.domain.User;

import java.util.List;

public interface UserUseCase {

    Boolean create(User user);

    User get(String userId);

    Boolean delete(String userId);

    List<User> getAllUsers();

    List<String> cleanupInactiveUsers();
}
