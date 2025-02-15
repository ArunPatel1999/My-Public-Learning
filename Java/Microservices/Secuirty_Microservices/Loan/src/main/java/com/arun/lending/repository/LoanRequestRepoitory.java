package com.arun.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arun.lending.entity.LoanRequest;

@Repository
public interface LoanRequestRepoitory extends JpaRepository<LoanRequest, Integer> {

}
