package it.pagopa.interop.signalhub.history.cleanup.service.impl;

import it.pagopa.interop.signalhub.history.cleanup.config.AppConfig;
import it.pagopa.interop.signalhub.history.cleanup.repository.SignalRepository;
import it.pagopa.interop.signalhub.history.cleanup.service.impl.SignalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class SignalServiceImplTest {
    @InjectMocks
    private SignalServiceImpl signalService;

    @Mock
    private SignalRepository signalRepository;

    @Mock
    private AppConfig appConfig;

    @Test
    void testDeleteSignal() {
        Mockito.when(appConfig.getDelayDays()).thenReturn("30");
        Mockito.when(signalRepository.deleteByDate(Mockito.any())).thenReturn(Mono.empty());
        signalService.cleanSignal();
        Mockito.verify(signalRepository, Mockito.times(1)).deleteByDate(Mockito.any());
    }
}
