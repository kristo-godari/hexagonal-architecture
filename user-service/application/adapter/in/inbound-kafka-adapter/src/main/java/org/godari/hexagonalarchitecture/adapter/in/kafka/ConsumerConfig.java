package org.godari.hexagonalarchitecture.adapter.in.kafka;

import lombok.AllArgsConstructor;
import org.godari.hexagonalarchitecture.common.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class ConsumerConfig {

    private InboundKafkaAdapter inboundKafkaAdapter;

    @Bean
    public Consumer<Message<User>> createUserConsumer() {
        return message -> inboundKafkaAdapter.processMessage(message.getPayload());
    }
}
