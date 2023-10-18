package it.pagopa.interop.signalhub.history.cleanup.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AppConfigTest {
    @InjectMocks
    AppConfig appConfig;
    @Test
    public void testDelayDays() {

        appConfig.setDelayDays("10");

        assertEquals("10", appConfig.getDelayDays());
    }
}
