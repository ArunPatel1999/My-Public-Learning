package com.arun;


import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class BackPressureTest {

    @Test
    void firstBackPressure() {
        Flux<Integer> data = Flux.range(0,100).log();

        data.onBackpressureDrop(integer -> {
                    System.out.println("drop value => "+integer);
            })
            .subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(4);
            }

            @Override
            protected void hookOnNext(Integer value) {
                System.out.println("Data =>"+value);
              //  if(value == 3) cancel();
                  if(value == 3) hookOnCancel();
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("Complete");
            }
        });
    }

    @Test
    void firstBackPressureBuffer() {
        Flux<Integer> data = Flux.range(0,100).log();

        data
                .onBackpressureBuffer(
                        10,
                        i -> System.out.println("vallue in buffer =>"+i)
                )
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(4);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("Data =>"+value);
                        //  if(value == 3) cancel();
                        if(value == 3) hookOnCancel();
                    }

                    @Override
                    protected void hookOnComplete() {
                        System.out.println("Complete");
                    }

                });
    }

    @Test
    void firstBackPressureError() {
        Flux<Integer> data = Flux.range(0,100).log();

        data.onBackpressureError()
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(4);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("Data =>"+value);
                        //  if(value == 3) cancel();
                        if(value == 3) hookOnCancel();
                    }

                    @Override
                    protected void hookOnComplete() {
                        System.out.println("Complete");
                    }

                    @Override
                    protected void hookOnError(Throwable throwable) {
                        System.out.println("Error =>"+throwable.getLocalizedMessage());
                    }

                    @Override
                    protected void hookOnCancel() {
                        super.hookOnCancel();
                    }
                });
    }
}
