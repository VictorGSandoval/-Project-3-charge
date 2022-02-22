package com.nttdata.charge.controller;

import com.nttdata.charge.model.Credit;
import com.nttdata.charge.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/charge-credit")
public class ChargeCredit {

    @Autowired
    CreditService creditService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Credit> getChargeCredit(){
        System.out.println("Listar cobros de creditos");
        return creditService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Credit> saveChargeCredit(@RequestBody Credit credit){
        System.out.println("Guardar cobro de credito");
        return creditService.save(credit);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Credit> updateChargeCredit(@RequestBody Credit credit){
        System.out.println("Actualizar cobro de credito");
        return creditService.update(credit);
    }

    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Credit> deleteChargeCredit(@PathVariable String id){
        System.out.println("Eliminar cobro de credito - cambiar status a false");
        return creditService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<Credit> findChargeCreditByCode(@PathVariable String code){
        System.out.println("Buscar cobro de credito");
        return creditService.findbyCodeCharge(code);
    }
}
