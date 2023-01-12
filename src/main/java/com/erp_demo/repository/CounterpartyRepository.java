package com.erp_demo.repository;

import com.erp_demo.entity.CounterpartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterpartyRepository extends JpaRepository<CounterpartyEntity, Integer> {
}
