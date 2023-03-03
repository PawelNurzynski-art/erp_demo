package com.erp_demo.repositories;

import com.erp_demo.entities.CounterpartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CounterpartyRepository extends JpaRepository<CounterpartyEntity, UUID> {

}
