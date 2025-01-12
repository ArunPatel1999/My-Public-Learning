package com.arun;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class HotAndColdStream {

    @Test
    void coldStream() {
        Flux<Integer> data = Flux.range(0,10);

        data.subscribe(z -> System.out.println("first =>"+z));
        data.subscribe(z -> System.out.println("second =>"+z));
    }

    @Test
    void HotStream() throws InterruptedException {
        Flux<Integer> data = Flux.range(0,10).delayElements(Duration.ofMillis(1000));

        ConnectableFlux<Integer> publisher = data.publish();
        publisher.connect();

        publisher.subscribe(z -> System.out.println("first =>"+z));
        Thread.sleep(4000);
        publisher.subscribe(z -> System.out.println("second =>"+z));
        Thread.sleep(10000);
    }

}
