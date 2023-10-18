package it.pagopa.interop.signalhub.history.cleanup.service.impl;

import it.pagopa.interop.signalhub.history.cleanup.config.AppConfig;
import it.pagopa.interop.signalhub.history.cleanup.repository.SignalRepository;
import it.pagopa.interop.signalhub.history.cleanup.service.SignalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
@AllArgsConstructor
public class SignalServiceImpl implements SignalService {

    @Autowired
    private SignalRepository signalRepository;

    @Autowired
    private AppConfig appConfig;

    public void deleteSignal() {
        LocalDate pastDate = LocalDate.now().minus(Long.parseLong(appConfig.getDelayDays()), ChronoUnit.DAYS);

        signalRepository.deleteByDateBefore(pastDate)
                .doOnSuccess(x -> log.info("record success"))
                .doOnError(x ->   log.error("Find an error {}",x.getMessage()))
                .subscribe();
    }

}


