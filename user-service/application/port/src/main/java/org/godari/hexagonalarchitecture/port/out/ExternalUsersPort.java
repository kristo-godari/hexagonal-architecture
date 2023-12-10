package org.godari.hexagonalarchitecture.port.out;

import org.godari.hexagonalarchitecture.common.domain.User;

import java.util.List;

public interface ExternalUsersPort {

    List<User> getUsers();
}