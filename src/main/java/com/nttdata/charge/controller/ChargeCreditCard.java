package com.nttdata.charge.controller;

import com.nttdata.charge.model.CreditCard;
import com.nttdata.charge.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/charge-credit-card")
public class ChargeCreditCard {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CreditCard> getChargeCreditCard(){
        System.out.println("Listar cobros de tarjetas de creditos");
        return creditCardService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreditCard> saveChargeCreditCard(@RequestBody CreditCard creditCard){
        System.out.println("Guardar cobro de tarjeta de credito");
        return creditCardService.save(creditCard);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CreditCard> updateChargeCreditCard(@RequestBody CreditCard creditCard){
        System.out.println("Actualizar cobro de tarjeta de credito");
        return creditCardService.update(creditCard);
    }

    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CreditCard> deleteChargeCreditCard(@PathVariable String id){
        System.out.println("Eliminar cobro de tarjeta de credito  - cambiar status a false");
        return creditCardService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<CreditCard> findChargeCreditCardByCode(@PathVariable String code){
        System.out.println("Buscar cobro de tarjeta de credito ");
        return creditCardService.findbyCodeCharge(code);
    }
}
