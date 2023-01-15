package com.erp_demo.repository;

import com.erp_demo.entity.GoodStorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodStorageRepository extends JpaRepository<GoodStorageEntity, Integer> {
}
