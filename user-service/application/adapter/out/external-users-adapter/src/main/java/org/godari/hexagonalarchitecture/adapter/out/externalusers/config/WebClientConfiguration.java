package org.godari.hexagonalarchitecture.adapter.out.externalusers.config;

import org.godari.hexagonalarchitecture.adapter.out.externalusers.client.ReqResClient;
import org.godari.hexagonalarchitecture.adapter.out.externalusers.properties.ReqRestClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfiguration {

    @Bean
    public ReqResClient reqResClient(ReqRestClientProperties properties) {

        WebClient webClient = WebClient.builder()
                .baseUrl(properties.getUrl())
                .defaultStatusHandler(
                        httpStatusCode -> HttpStatus.NOT_FOUND == httpStatusCode,
                        response -> Mono.empty())
                .build();

        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build()
                .createClient(ReqResClient.class);
    }
}

