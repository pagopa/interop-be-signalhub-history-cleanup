package it.pagopa.interop.signalhub.history.cleanup.entity;

import it.pagopa.interop.signalhub.history.cleanup.entities.Signal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class SignalTest {

    @InjectMocks
    private Signal signal;

    @BeforeEach
    public void setUp() {
        signal = new Signal();
    }

    @Test
    public void testId() {
        Long id = 1L;
        signal.setId(id);
        assertEquals(id, signal.getId());
    }
    @Test
    public void testSignalId() {
        Long signalId = 123L;
        signal.setSignalId(signalId);
        assertEquals(signalId, signal.getSignalId());
    }
    @Test
    public void testObjectId() {
        String objectId = "testObject";
        signal.setObjectId(objectId);
        assertEquals(objectId, signal.getObjectId());
    }

    @Test
    public void testEserviceId() {
        String eserviceId = "testEservice";
        signal.setEserviceId(eserviceId);
        assertEquals(eserviceId, signal.getEserviceId());
    }
    @Test
    public void testObjectType() {
        String objectType = "testType";
        signal.setObjectType(objectType);
        assertEquals(objectType, signal.getObjectType());
    }

    @Test
    public void testSignalType() {
        String signalType = "testSignal";
        signal.setSignalType(signalType);
        assertEquals(signalType, signal.getSignalType());
    }

    @Test
    public void testTmstInsert() {
        Instant tmstInsert = Instant.now();
        signal.setTmstInsert(tmstInsert);
        assertEquals(tmstInsert, signal.getTmstInsert());
    }

}
