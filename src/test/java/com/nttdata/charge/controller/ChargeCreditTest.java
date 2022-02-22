package com.nttdata.charge.controller;

import com.nttdata.charge.model.Credit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.RequestBodySpec;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebFluxTest(ChargeCredit.class)
public class ChargeCreditTest {
    @Autowired
	private  WebTestClient webClient;
	
	
	@MockBean
	ChargeCredit service;

    Credit credit;
    @BeforeEach
	void setUp() throws Exception {
		credit=new Credit("1","1","1",(float) 2000,true);
		
	}
    @Test
    void testDeleteChargeCredit() {
        Mockito.when(service.deleteChargeCredit(credit.getId()))
        .thenReturn(Mono.just(credit));
        webClient.put().uri("/charge-credit/delete/1")
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(credit), Credit.class)
				.exchange()
				.expectStatus().isEqualTo(200);

    }

    @Test
    void testFindChargeCreditByCode() {
        Mockito.when(service.findChargeCreditByCode(credit.getCodeCharge()))
        .thenReturn(Mono.just(credit));

      ((RequestBodySpec) webClient.get().uri("/charge-credit/1")
				.accept(MediaType.APPLICATION_JSON))
				.body(Mono.just(credit), Credit.class)
				.exchange()
				.expectStatus()
                .isEqualTo(200);

    }

    @Test
    void testGetChargeCredit() {
        Flux<Credit> creditFlux = Flux.just(credit);
	    Mockito.when(service.getChargeCredit())
        .thenReturn(creditFlux);
	    Flux<Credit> flux = webClient.get().uri("/charge-credit")
	    		.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.returnResult(Credit.class)
				.getResponseBody();
	   
	    StepVerifier.create(flux)
			.expectSubscription()
			.expectNext(credit)
			.verifyComplete();
    }

    @Test
    void testSaveChargeCredit() {
        Mockito.when(service.saveChargeCredit(credit))
          .thenReturn(Mono.just(credit));
          
        webClient.post().uri("/charge-credit")
              .accept(MediaType.APPLICATION_JSON)
              .body(Mono.just(credit), Credit.class)
              .exchange()
              .expectStatus().isCreated();

    }

    @Test
    void testUpdateChargeCredit() {
        Mockito.when(service.updateChargeCredit(credit))
		    .thenReturn(Mono.just(credit));

		  webClient.put().uri("/charge-credit/update")
				  .accept(MediaType.APPLICATION_JSON)
				  .body(Mono.just(credit), Credit.class)
				  .exchange()
				  .expectStatus().isEqualTo(200);

    }
}
