package com.nttdata.charge.repository;

import com.nttdata.charge.model.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {
    Mono<Credit> findbyCodeCharge(String code);
}
