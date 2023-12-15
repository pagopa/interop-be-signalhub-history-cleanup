package it.pagopa.interop.signalhub.history.cleanup.service.impl;

import it.pagopa.interop.signalhub.history.cleanup.config.AppConfig;
import it.pagopa.interop.signalhub.history.cleanup.repository.SignalRepository;
import it.pagopa.interop.signalhub.history.cleanup.service.SignalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
@AllArgsConstructor
@Service
public class SignalServiceImpl implements SignalService {
    private final SignalRepository signalRepository;
    private final AppConfig appConfig;

    public void cleanSignal() {
        Instant pastDate = Instant.now().minus(Long.parseLong(appConfig.getDelayHours()), ChronoUnit.HOURS);
        signalRepository.deleteByDate(pastDate)
                .doOnSuccess(x -> log.info("clean complete with success"))
                .doOnError(ex ->   log.error("Error on signal cleanup", ex))
                .subscribe();
    }

}


