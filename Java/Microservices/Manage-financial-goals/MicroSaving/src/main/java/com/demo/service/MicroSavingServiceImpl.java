package com.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.MicroSaving;
import com.demo.exception.CustomeException;
import com.demo.repository.MicroSavingRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MicroSavingServiceImpl implements MicroSavingService {

	private MicroSavingRepository microSavingRepository;

	@Override
	public MicroSaving getById(long id) throws CustomeException {
		return microSavingRepository.findById(id).orElseThrow(() -> new CustomeException(404, "micro saving not found"));
	}

	@Override
	public MicroSaving save(MicroSaving microSaving) {
		log.info("microSaving save");		
		microSaving.setCreatedDate(LocalDateTime.now());
		return microSavingRepository.save(microSaving);
	}

	@Override
	public List<MicroSaving> getByGoalId(int goalId) {
		return microSavingRepository.findByGoalId(goalId);
	}
	
}
