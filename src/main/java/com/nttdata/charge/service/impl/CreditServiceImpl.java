package com.nttdata.charge.service.impl;

import com.nttdata.charge.model.Credit;
import com.nttdata.charge.repository.CreditRepository;
import com.nttdata.charge.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository creditRepository;

    @Override
    public Flux<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> save(Credit entity) {
        return creditRepository.save(entity);
    }

    @Override
    public Mono<Credit> update(Credit entity) {
        return  creditRepository.findById(entity.getId())
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setCodeCredit(entity.getCodeCredit());
                    origin.setStatus(entity.getStatus());
                    origin.setCodeCharge(entity.getCodeCharge());
                    origin.setAmount(entity.getAmount());
                    return creditRepository.save(origin);
                });
    }

    @Override
    public Mono<Credit> deleteById(String id) {
        return creditRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setStatus(false);
                    return creditRepository.save(origin);
                });
    }

    @Override
    public Mono<Credit> findById(String id) {
        return creditRepository.findById(id);
    }

    @Override
    public Mono<Credit> findbyCodeCharge(String code) {
        return creditRepository.findbyCodeCharge(code);
    }
}
