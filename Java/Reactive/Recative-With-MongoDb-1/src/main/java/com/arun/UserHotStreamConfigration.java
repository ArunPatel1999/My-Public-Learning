package com.arun;

import java.time.Duration;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.arun.entity.UserHotStream;
import com.arun.entity.UserHotStreamRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Profile("test")
@Component
@Slf4j
public class UserHotStreamConfigration implements CommandLineRunner {

	@Autowired private UserHotStreamRepository userHotStreamRepository;
	@Autowired private MongoTemplate mongoTemplate;
	

	@Override
	public void run(String... args) throws Exception {
		createdCappedCollection();
		addDataInUserHotStream();
	}
	
	private void addDataInUserHotStream() {
		Flux<UserHotStream> data = Flux.interval(Duration.ofSeconds(1)).map(x -> new UserHotStream(""+x, "name "+x, Integer.parseInt(""+x+26), new Date()));
		userHotStreamRepository.insert(data).subscribe(x -> log.info("insertIng =>"+x));
	}

	private void createdCappedCollection() {
		mongoTemplate.dropCollection(UserHotStream.class);
		mongoTemplate.createCollection(UserHotStream.class, CollectionOptions.empty().maxDocuments(20).size(50000).capped());
	}


}
