package it.pagopa.interop.signalhub.history.cleanup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableR2dbcAuditing
@EnableScheduling
public class SignalHubHistoryCleanupApplication {

	public static void main(String[] args) {


		SpringApplication.run(SignalHubHistoryCleanupApplication.class, args);
	}

}
