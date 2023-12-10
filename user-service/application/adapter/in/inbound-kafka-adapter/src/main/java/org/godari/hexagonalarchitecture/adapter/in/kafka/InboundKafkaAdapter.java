package org.godari.hexagonalarchitecture.adapter.in.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.godari.hexagonalarchitecture.common.domain.User;
import org.godari.hexagonalarchitecture.port.in.UserUseCase;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class InboundKafkaAdapter {

    private UserUseCase userUseCase;

    public void processMessage(User user) {

        Boolean result = userUseCase.create(user);

        log.info("User creation operation executed with status: {}", result);
    }
}