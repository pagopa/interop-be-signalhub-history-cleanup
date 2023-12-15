package it.pagopa.interop.signalhub.history.cleanup.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AppConfigTest {
    
    @InjectMocks
    AppConfig appConfig;
    
    @Test
    void testDelayDays() {
        appConfig.setDelayHours("10");
        assertEquals("10", appConfig.getDelayHours());
    }
}
