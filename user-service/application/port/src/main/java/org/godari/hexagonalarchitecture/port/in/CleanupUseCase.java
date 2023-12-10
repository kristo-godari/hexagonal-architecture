package org.godari.hexagonalarchitecture.port.in;

import org.godari.hexagonalarchitecture.common.domain.User;

public interface CleanupUseCase {

    Boolean create(User user);

    User get(String userId);

    Boolean delete(String userId);
}
