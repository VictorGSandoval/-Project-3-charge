package com.nttdata.charge.service;

import com.nttdata.charge.model.Credit;
import reactor.core.publisher.Mono;

public interface CreditService extends CrudService<Credit, String> {

    Mono<Credit> findbyCodeCharge(String code);
}
