package com.erp_demo.repository;

import com.erp_demo.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<GoodEntity, Integer> {
}
