package com.example.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("spring boot")
//                .then(Mono.error(new RuntimeException("Exception Occurred in Mono")))
                .log();
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> flux = Flux.just("AWS", "GCP", "AZURE")
                .concatWithValues("DigitalOcean")
//                .concatWith(Flux.error(new RuntimeException("Exception Occurred in Flux")))
                .concatWithValues("Linode")
                .log();
        flux.subscribe(System.out::println, (e) ->System.out.println(e.getMessage()));
    }

}
