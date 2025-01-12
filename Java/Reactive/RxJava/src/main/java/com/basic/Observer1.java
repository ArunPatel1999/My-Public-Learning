package com.basic;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Observer1 {
    public static void main(String[] args) {

        Observable<String> observable = Observable.just("kusrh","sliuf9","osyuf98ws","liusg9o");

        Observer<String> observer = new Observer<String>() {
        	Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
            	disposable = d;
                System.out.println("subscribe Data: => "+d);
            }

            @Override
            public void onNext(String integer) {
            	if(integer.equals("osyuf98ws")) disposable.dispose(); 
                System.out.println("Next Data: => "+integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error On Data: => "+e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("=====Completed======== ");
            }
        };

        observable.subscribe(observer);
    }
}
