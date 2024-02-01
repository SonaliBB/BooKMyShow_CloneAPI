package com.jsp.CloneAPIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneAPIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneAPIBookMyShow.repository.ProductionHouseRepo;

@Repository
public class ProductionHouseDao {

@Autowired
private ProductionHouseRepo repo;

public ProductionHouse saveProductionHouse(ProductionHouse house) {
	return repo.save(house);
}

public ProductionHouse updateProductionHouse(ProductionHouse house,long productionId) {
	Optional<ProductionHouse> optional=repo.findById(productionId);
	if (optional.isPresent()) {
		house.setProduction_id(productionId);
		house.setOwner(optional.get().getOwner());
		house.setMovies(optional.get().getMovies());
		repo.save(house);
		return house;
	}
	return null;
}

public  ProductionHouse  getProductionHouseById(long productionId) {
	Optional<ProductionHouse> optional=repo.findById( productionId);
	if (optional.isPresent()) {
		return optional.get();
	}
	return null;
}

public ProductionHouse  deleteProductionHouseById(long productionId) {
	Optional<ProductionHouse> optional=repo.findById(productionId);
	if (optional.isPresent()) {
		ProductionHouse house=optional.get();
		house.setMovies(null);
		house.setOwner(null);
		repo.delete(house);
		return house;
	}
	return null;
}


}
