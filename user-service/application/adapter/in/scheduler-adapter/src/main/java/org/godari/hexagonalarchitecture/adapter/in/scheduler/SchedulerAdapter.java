package org.godari.hexagonalarchitecture.adapter.in.scheduler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.godari.hexagonalarchitecture.port.in.UserUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class SchedulerAdapter {

    private UserUseCase userUseCase;

    @Scheduled(fixedDelay = 600_000)
    public void cleanupInactiveUsers() {
        log.info("Starting user cleanup process!");

        List<String> deletedUserIds = userUseCase.cleanupInactiveUsers();

        if(deletedUserIds.isEmpty()) {
            log.info("Cleanup process run! No users found to delete!");
            return;
        }

        log.info("Cleanup process run! The following users are deleted users: {}", deletedUserIds);
    }
}
