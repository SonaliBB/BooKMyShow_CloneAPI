package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.ProductionHouse;

public interface ProductionHouseRepo  extends JpaRepository<ProductionHouse, Long>{

	Optional<ProductionHouse> findById(long productionId);

}
