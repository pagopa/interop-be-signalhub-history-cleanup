package it.pagopa.interop.signalhub.history.cleanup.repository;

import it.pagopa.interop.signalhub.history.cleanup.entities.SignalEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface SignalRepository extends ReactiveCrudRepository<SignalEntity, Long> {

    @Query("delete from signal s where s.tmst_Insert < :date")
    Mono<Void> deleteByDateBefore(LocalDate date );

}