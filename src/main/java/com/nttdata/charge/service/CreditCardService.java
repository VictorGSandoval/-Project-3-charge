package com.nttdata.charge.service;

import com.nttdata.charge.model.Credit;
import com.nttdata.charge.model.CreditCard;
import reactor.core.publisher.Mono;

public interface CreditCardService extends CrudService<CreditCard, String> {

    Mono<CreditCard> findbyCodeCharge(String code);
}
