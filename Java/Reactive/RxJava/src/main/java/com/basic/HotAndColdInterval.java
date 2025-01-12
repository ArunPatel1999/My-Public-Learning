package com.basic;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

public class HotAndColdInterval {
	public static void main(String[] args) {
		cold();
		coldCompositeDisposable();
		hot();
	}
	
	public static void cold() {
		System.out.println("======COLD======");
	     Observable<Long> data =	Observable.interval(1, TimeUnit.SECONDS);
	     
	     data.subscribe(x -> System.out.println("sub 1: => "+x));
	     sleep(1000);
	     data.subscribe(x -> System.out.println("sub 2: => "+x));
	     sleep(2000);
	}
	
	public static void coldCompositeDisposable() {
		CompositeDisposable compositeDisposable = new CompositeDisposable();
		System.out.println("======COLD  Composite Disposable======");
	     Observable<Long> data =	Observable.interval(1, TimeUnit.SECONDS);
	     
	     Disposable disposable1 = data.subscribe(x -> System.out.println("sub 1: => "+x));
	     sleep(1000);
	     Disposable disposable2 = data.subscribe(x -> System.out.println("sub 2: => "+x));
	     compositeDisposable.addAll(disposable1,disposable2);
	     compositeDisposable.dispose();
	     sleep(2000);
	}
	
	public static void hot() {
		System.out.println("======HOT======");
		ConnectableObservable<Long> data =	Observable.interval(1, TimeUnit.SECONDS).publish();
		
		data.subscribe(x -> System.out.println("sub 1: => "+x));
		sleep(1000);
		data.subscribe(x -> System.out.println("sub 2: => "+x));
		sleep(2000);
		data.connect();
	}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
