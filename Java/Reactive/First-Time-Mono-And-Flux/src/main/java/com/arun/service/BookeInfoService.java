package com.arun.service;

import java.util.LinkedList;
import java.util.List;

import com.arun.entitys.BookInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BookeInfoService {

	public List<BookInfo>  getData() {
		List<BookInfo> list = new LinkedList<>();
		list.add(new BookInfo(1, "First Book", 1546));
		list.add(new BookInfo(2, "Two Book", 4752));
		list.add(new BookInfo(3, "Three Book", 2000));
		list.add(new BookInfo(4, "Fourth Book", 2020));
		list.add(new BookInfo(5, "Fifth Book", 2021));
		return list;
	}
	
	public Flux<BookInfo> getAll() {

		return Flux.fromIterable(getData());
	}
	
	public Mono<BookInfo> getById(int id) throws Exception {
		BookInfo bookInfo = getData().stream().filter(x -> x.getId()==id).findAny().orElseThrow(() -> new Exception("No Data Found"));
		return Mono.just(bookInfo);
	}
		
}
