package it.pagopa.interop.signalhub.history.cleanup.execution;

import it.pagopa.interop.signalhub.history.cleanup.controller.SignalServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class BatchTaskExecutor implements CommandLineRunner {
    @Autowired
    private SignalServiceController signalServiceController;

    @Override
    public void run(String... args) throws Exception {
        signalServiceController.cleanSignal();
    }
}
