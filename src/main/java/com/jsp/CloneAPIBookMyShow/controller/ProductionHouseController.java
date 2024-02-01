package com.jsp.CloneAPIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneAPIBookMyShow.dto.ProductionHouseDto;
import com.jsp.CloneAPIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneAPIBookMyShow.service.ProductionHouseService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/productionhouse")
public class ProductionHouseController {
@Autowired
private ProductionHouseService houseService;

@ApiOperation(value = "save production house",notes = "api used to save production house")
@ApiResponses(value = {@ApiResponse(code = 201,message = "production house saved successfully"),@ApiResponse(code = 404,message = "production house dosen't saved  ,please enter valid details")})

@PostMapping
public  ResponseEntity<ResponseStructure<ProductionHouse>>	 saveProductionHouse(@RequestParam long ownerId,@RequestBody ProductionHouseDto houseDto) {
	return houseService.saveProductionHouse(ownerId, houseDto);
}
@ApiOperation(value = "update production house",notes = "api used to update production house")
@ApiResponses(value = {@ApiResponse(code = 200,message = "production house updated successfully"),@ApiResponse(code = 404,message = "production house dosen't update  ,please enter valid details")})
@PutMapping
public  ResponseEntity<ResponseStructure<ProductionHouse>>	 updateProductionHouse(@RequestParam long productionHouseId,@RequestBody ProductionHouseDto houseDto) {
	return houseService.saveProductionHouse(productionHouseId, houseDto);
}
@ApiOperation(value = "get production house",notes = "api used to get production house")
@ApiResponses(value = {@ApiResponse(code = 301,message = "production house fetched successfully"),@ApiResponse(code = 404,message = "production house dosen't deleted  ,please enter valid details")})

@GetMapping
public  ResponseEntity<ResponseStructure<ProductionHouse>>	 getProductionHouseById(@RequestParam long ownerId) {
	return houseService.getProductionHouseById(ownerId);
}

@ApiOperation(value = "delete production house",notes = "api used to delete production house")
@ApiResponses(value = {@ApiResponse(code = 200,message = "production house deleted successfully"),@ApiResponse(code = 404,message = "production house dosen't deleted  ,please enter valid details")})

@DeleteMapping
public  ResponseEntity<ResponseStructure<ProductionHouse>>	 deleteProductionHouseById(@RequestParam long ownerId) {
	return houseService.deleteProductionHouseById(ownerId);
}

}
