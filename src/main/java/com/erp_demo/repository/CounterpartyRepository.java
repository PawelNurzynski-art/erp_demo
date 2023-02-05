package com.erp_demo.repository;

import com.erp_demo.entity.CounterpartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CounterpartyRepository extends JpaRepository<CounterpartyEntity, UUID> {

}
