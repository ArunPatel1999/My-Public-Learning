package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.MicroSaving;

@Repository
public interface MicroSavingRepository extends JpaRepository<MicroSaving, Long> {

	List<MicroSaving> findByGoalId(int userId);

}
