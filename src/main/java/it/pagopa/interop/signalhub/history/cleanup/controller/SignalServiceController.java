package it.pagopa.interop.signalhub.history.cleanup.controller;

import it.pagopa.interop.signalhub.history.cleanup.exception.PDNDBatchAlreadyExistException;
import it.pagopa.interop.signalhub.history.cleanup.service.SignalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@AllArgsConstructor
public class SignalServiceController {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final SignalService signalService;

    public void cleanSignal(){
        log.info("CleanSignal Started: {}", dateTimeFormatter.format(LocalDateTime.now()));
        try {
            signalService.cleanSignal();
        } catch (PDNDBatchAlreadyExistException ex) {
            log.error("An error occurred ", ex);
        }
        log.info("CleanSignal Ended: {}", dateTimeFormatter.format(LocalDateTime.now()));
    }


}
