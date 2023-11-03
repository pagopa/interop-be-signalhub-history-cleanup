package it.pagopa.interop.signalhub.history.cleanup.repository;

import it.pagopa.interop.signalhub.history.cleanup.entities.Signal;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface SignalRepository extends ReactiveCrudRepository<Signal, Long> {

    @Query("delete from SIGNAL  where tmst_Insert < :date")
    Mono<Void> deleteByDate(LocalDate date );

}