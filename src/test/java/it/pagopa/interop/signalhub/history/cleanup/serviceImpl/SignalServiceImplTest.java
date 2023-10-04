package it.pagopa.interop.signalhub.history.cleanup.serviceImpl;

import it.pagopa.interop.signalhub.history.cleanup.conifg.AppConfig;
import it.pagopa.interop.signalhub.history.cleanup.repository.SignalRepository;
import it.pagopa.interop.signalhub.history.cleanup.service.impl.SignalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@ExtendWith(MockitoExtension.class)
public class SignalServiceImplTest {
    @InjectMocks
    private SignalServiceImpl signalService;

    @Mock
    private SignalRepository signalRepository;

    @Mock
    private AppConfig appConfig;

    @Test
    void testDeleteSignal() throws FileNotFoundException {
        LocalDate expectedDate = LocalDate.now().minus(30, ChronoUnit.DAYS);

        Mockito.when(appConfig.getDelayDays()).thenReturn("30");

        Mockito.when(signalRepository.deleteByDateBefore(Mockito.any())).thenReturn(Mono.empty());
        signalService.deleteSignal();
        Mockito.verify(signalRepository, Mockito.times(1)).deleteByDateBefore(Mockito.any());



    }
}
