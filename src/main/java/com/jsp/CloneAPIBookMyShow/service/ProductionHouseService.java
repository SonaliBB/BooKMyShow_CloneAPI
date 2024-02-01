package com.jsp.CloneAPIBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneAPIBookMyShow.dao.OwnerDao;
import com.jsp.CloneAPIBookMyShow.dao.ProductionHouseDao;
import com.jsp.CloneAPIBookMyShow.dto.ProductionHouseDto;
import com.jsp.CloneAPIBookMyShow.entity.Owner;
import com.jsp.CloneAPIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneAPIBookMyShow.exception.OwnerIdNotFoundException;
import com.jsp.CloneAPIBookMyShow.exception.ProductionHouseNotFoundException;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

@Service
public class ProductionHouseService {
@Autowired
private ProductionHouseDao houseDao;

@Autowired
private ModelMapper modelMapper;

@Autowired
private OwnerDao ownerDao;

public ResponseEntity<ResponseStructure<ProductionHouse>> saveProductionHouse(long ownerId,ProductionHouseDto productionHouseDto){
	Owner dbOwner=ownerDao.findOwnerById(ownerId);
if (dbOwner!=null) {
	ProductionHouse house=this.modelMapper.map(productionHouseDto, ProductionHouse.class);
	
          if(dbOwner.getHouse().isEmpty()) {
		    List<ProductionHouse> list=new ArrayList<>();
		    list.add(house);
		    dbOwner.setHouse(list);
	        }else {
	     	List<ProductionHouse> list=dbOwner.getHouse();
	    	list.add(house);
	    	dbOwner.setHouse(list);
	}
          house.setOwner(dbOwner);
          ProductionHouse dbProductionHouse=houseDao.saveProductionHouse(house);
          ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
          structure.setMessage("ProductionHouse Added Successfully");
          structure.setStatus(HttpStatus.CREATED.value());
          structure.setData(dbProductionHouse);
          return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.CREATED);	
}else {
	throw new OwnerIdNotFoundException("Owner id not found");
}
}
	public ResponseEntity<ResponseStructure<ProductionHouse>> updateProductionHouse(long productionHouseId,ProductionHouseDto houseDto) {
		ProductionHouse house=this.modelMapper.map(houseDto, ProductionHouse.class);
		ProductionHouse dbHouse=houseDao.updateProductionHouse(house, productionHouseId);
		if (dbHouse!=null) {
			 ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
	          structure.setMessage("ProductionHouse updated Successfully");
	          structure.setStatus(HttpStatus.OK.value());
	          structure.setData(dbHouse);
	          return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.OK);
	          }
	else {
		throw new ProductionHouseNotFoundException("Production house id not found"	);
	}
		
	}

	public ResponseEntity<ResponseStructure<ProductionHouse>> getProductionHouseById(long productionHouseId) {
		
		ProductionHouse dbHouse=houseDao.getProductionHouseById(productionHouseId);
		if (dbHouse!=null) {
			 ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
	          structure.setMessage("ProductionHouse found Successfully");
	          structure.setStatus(HttpStatus.FOUND.value());
	          structure.setData(dbHouse);
	          return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.FOUND);
	          }
	else {
		throw new ProductionHouseNotFoundException("Productionhouse id not found"	);
	}
		
	}


public ResponseEntity<ResponseStructure<ProductionHouse>> deleteProductionHouseById(long productionHouseId) {
	
	ProductionHouse dbHouse=houseDao.deleteProductionHouseById(productionHouseId);
	if (dbHouse!=null) {
		 ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
          structure.setMessage("ProductionHouse deleted Successfully");
          structure.setStatus(HttpStatus.FOUND.value());
          structure.setData(dbHouse);
          return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.FOUND);
          }
else {
	throw new ProductionHouseNotFoundException("Productionhouse id not found"	);
}
	
}
	
}
