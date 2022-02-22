package com.nttdata.charge.repository;

import com.nttdata.charge.model.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {

    Mono<CreditCard> findbyCodeCharge(String code);
}
