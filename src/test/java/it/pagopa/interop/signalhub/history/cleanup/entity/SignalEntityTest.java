package it.pagopa.interop.signalhub.history.cleanup.entity;

import it.pagopa.interop.signalhub.history.cleanup.entities.SignalEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class SignalEntityTest {

    @InjectMocks
    private SignalEntity signalEntity;

    @BeforeEach
    public void setUp() {
        signalEntity = new SignalEntity();
    }

    @Test
    public void testId() {
        Long id = 1L;
        signalEntity.setId(id);
        assertEquals(id, signalEntity.getId());
    }
    @Test
    public void testSignalId() {
        Long signalId = 123L;
        signalEntity.setSignalId(signalId);
        assertEquals(signalId, signalEntity.getSignalId());
    }
    @Test
    public void testObjectId() {
        String objectId = "testObject";
        signalEntity.setObjectId(objectId);
        assertEquals(objectId, signalEntity.getObjectId());
    }

    @Test
    public void testEserviceId() {
        String eserviceId = "testEservice";
        signalEntity.setEserviceId(eserviceId);
        assertEquals(eserviceId, signalEntity.getEserviceId());
    }
    @Test
    public void testObjectType() {
        String objectType = "testType";
        signalEntity.setObjectType(objectType);
        assertEquals(objectType, signalEntity.getObjectType());
    }

    @Test
    public void testSignalType() {
        String signalType = "testSignal";
        signalEntity.setSignalType(signalType);
        assertEquals(signalType, signalEntity.getSignalType());
    }

    @Test
    public void testTmstInsert() {
        Instant tmstInsert = Instant.now();
        signalEntity.setTmstInsert(tmstInsert);
        assertEquals(tmstInsert, signalEntity.getTmstInsert());
    }

}
