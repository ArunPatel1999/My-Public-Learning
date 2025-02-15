package com.arun.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arun.lending.entity.LoanApproved;

@Repository
public interface LoanApprovedRepository extends JpaRepository<LoanApproved, Integer> {

}
