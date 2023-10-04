package it.pagopa.interop.signalhub.history.cleanup.service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public interface SignalService {

    void deleteSignal();

}
