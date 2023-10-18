package it.pagopa.interop.signalhub.history.cleanup.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pdnd.history-cleanup")
@Getter
@Setter
public class AppConfig {

    private String delayDays;
}
