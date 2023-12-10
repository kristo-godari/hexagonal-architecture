package org.godari.hexagonalarchitecture.adapter.out.externalusers.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("user-service.external-services.req-rest")
public class ReqRestClientProperties{

    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
