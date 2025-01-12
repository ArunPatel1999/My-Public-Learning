package com.basic;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

class ObservableMain1 {
    public static void main(String[] args) {

        createObservableUsingJust();
        createObservableUsingRange();
        createObservableUsingfromIterable();
        createObservableUsingCreate();

    }

    private static void createObservableUsingJust() {
        System.out.println("====Using Just=====");
        Observable.just(0,1,2,3,4,6,7,8,945,45).subscribe(System.out::println).dispose();
    }
    private static void createObservableUsingRange() {
        System.out.println("====Using Rang=====");
        Observable.range(0,20).subscribe(System.out::println).dispose();
    }
    private static  void createObservableUsingfromIterable() {
        System.out.println("====Using fromIterable=====");
        List<Integer> data  = Arrays.asList(1,2,3,45,4,6,6,49,6,4,47,6,4,476,4);
        Observable.fromIterable(data).subscribe(System.out::println).dispose();
    }

    private static void createObservableUsingCreate() {
        System.out.println("====Using create=====");
        Observable<Object> data = Observable.create(emitter -> {
            emitter.onNext(45);
            emitter.onNext(4656);
            emitter.onNext(4556);
            emitter.onNext(66);
            emitter.onNext(null);
            emitter.onNext(89);
            emitter.onNext(132);

            emitter.onComplete();
        });
        data.subscribe(x -> System.out.println(x),
                exception -> System.out.println("Error is coming: "+exception),
                () ->  System.out.println("Completed")).dispose();
    }

}
