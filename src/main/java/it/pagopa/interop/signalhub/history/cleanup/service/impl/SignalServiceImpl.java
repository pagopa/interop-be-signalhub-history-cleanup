package it.pagopa.interop.signalhub.history.cleanup.service.impl;

import it.pagopa.interop.signalhub.history.cleanup.config.AppConfig;
import it.pagopa.interop.signalhub.history.cleanup.repository.SignalRepository;
import it.pagopa.interop.signalhub.history.cleanup.service.SignalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
@AllArgsConstructor
@Service
public class SignalServiceImpl implements SignalService {

    @Autowired
    private SignalRepository signalRepository;

    @Autowired
    private AppConfig appConfig;

    public void cleanSignal() {
        Instant pastDate = Instant.now().minus(Long.parseLong(appConfig.getDelayDays()), ChronoUnit.DAYS);
        signalRepository.deleteByDate(pastDate)
                .doOnSuccess(x -> log.info("clean complete with success"))
                .doOnError(ex ->   log.error("Error on signal cleanup {}",ex))
                .subscribe();
    }

}


