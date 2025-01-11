package com.demo.service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.entity.Goals;
import com.demo.entity.MicroSaving;
import com.demo.exception.CustomeException;
import com.demo.repository.GoalsRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class GoalsServiceImpl implements GoalsService{

	private GoalsRepository goalsRepository;
	private RestTemplate restTemplate;

	@Override
	public List<Goals> getAllGoals() {
		return goalsRepository.findAll();
	}

	@Override
	public Goals getById(long id) throws CustomeException {
		return goalsRepository.findById(id).orElseThrow(() -> new CustomeException(404, "gola not found"));
	}

	@Override
	public Goals save(Goals goals) {
		log.info("goals save");
		goals.setCreatedDate(LocalDateTime.now());
		return goalsRepository.save(goals);
	}

	@Override
	public List<Goals> getByUserId(int userId) {
		return goalsRepository.findByUserId(userId);
	}

	@Override
	public boolean savingAdd(long id, double amount, String text) throws CustomeException {
		log.info("saving Add => "+id+" and Amount => "+amount);
		if(amount < 100 || amount > 500)
			throw new CustomeException(409, "amount between 100 to 500");
		
		Goals goals = getById(id);
		if(goals.isGoalCompleted())
			throw new CustomeException(409, "Goal already Completed");
		
		MicroSaving microSaving = new MicroSaving();
		microSaving.setGoalId(id);
		microSaving.setAmount(amount);
		microSaving.setText(text);
		
		HttpEntity<MicroSaving> entity = new HttpEntity<>(microSaving);
		ResponseEntity<MicroSaving> response = restTemplate.exchange("http://MICROSAVING/api/saving", HttpMethod.POST, entity, MicroSaving.class);
		
		if(response.getStatusCodeValue() != 200)
			throw new CustomeException(409, "Internal Server error");
		
		goals.setTotalMicroSaving(goals.getTotalMicroSaving()+amount);
		if(goals.getTotalMicroSaving() >= goals.getAmount())
			goals.setGoalCompleted(true);
		
		goals.setLastSavingDate(LocalDateTime.now());
		goalsRepository.save(goals);
		return true;
	}

	@Override
	public Map<String, Object> getFullDetailsOfGoals(int goalId) throws CustomeException {
		
		Map<String, Object> result = new LinkedHashMap<>();
		
		Goals goals = getById(goalId);
		
		result.put("goalId", goals.getId());
		result.put("userId", goals.getUserId());
		result.put("goalTitle", goals.getGoalTitle());
		result.put("goalDescription", goals.getGoalDescription());
		result.put("amount", goals.getAmount());
		result.put("totalMicroSaving", goals.getTotalMicroSaving());
		
		result.put("listOfSaving", restTemplate.getForEntity("http://MICROSAVING/api/saving/getByGoalId/"+goalId, Object.class).getBody());
		
		result.put("createdDate", goals.getCreatedDate());
		result.put("lastSavingDate", goals.getLastSavingDate());
		result.put("goalCompleted", goals.isGoalCompleted());
		
		return result;
	}

	
}
