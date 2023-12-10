package org.godari.hexagonalarchitecture.adapter.out.externalusers;

import org.godari.hexagonalarchitecture.adapter.out.externalusers.client.ReqResClient;
import org.godari.hexagonalarchitecture.common.domain.User;
import org.godari.hexagonalarchitecture.port.out.ExternalUsersPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExternalUsersAdapter implements ExternalUsersPort {

    private final ReqResClient reqResClient;

    public ExternalUsersAdapter(ReqResClient reqResClient) {
        this.reqResClient = reqResClient;
    }

    @Override
    public List<User> getUsers() {
        return reqResClient.getAllUsers().userData()
                .stream()
                .map(extUser -> new User(extUser.firstName(), extUser.lastName()))
                .collect(Collectors.toList());
    }
}
