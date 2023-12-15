package it.pagopa.interop.signalhub.history.cleanup.execution;

import it.pagopa.interop.signalhub.history.cleanup.controller.SignalServiceController;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
@AllArgsConstructor
public class BatchTaskExecutor implements CommandLineRunner {
    private final SignalServiceController signalServiceController;

    @Override
    public void run(String... args) {
        signalServiceController.cleanSignal();
    }
}
