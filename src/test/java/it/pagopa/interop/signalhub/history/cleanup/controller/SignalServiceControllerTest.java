package it.pagopa.interop.signalhub.history.cleanup.controller;


import it.pagopa.interop.signalhub.history.cleanup.exception.PDNDBatchAlreadyExistException;
import it.pagopa.interop.signalhub.history.cleanup.service.SignalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SignalServiceControllerTest {

    @Mock
    private SignalService signalService;

    @InjectMocks
    private SignalServiceController signalServiceController;


    @Test
    void whenCleanSignalOk(){

        Mockito.doNothing().when(signalService).cleanSignal();

        this.signalServiceController.cleanSignal();

        Mockito.verify(signalService, Mockito.timeout(1000).times(1)).cleanSignal();

    }

    @Test
    void whenCleanSignalThrowPDNBatchAlreadyExistException(){

        Mockito.doThrow(new PDNDBatchAlreadyExistException())
                .when(signalService).cleanSignal();

        this.signalServiceController.cleanSignal();

        Mockito.verify(signalService, Mockito.timeout(1000).times(1)).cleanSignal();

    }




}
