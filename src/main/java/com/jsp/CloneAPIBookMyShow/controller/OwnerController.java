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

import com.jsp.CloneAPIBookMyShow.dto.OwnerDto;
import com.jsp.CloneAPIBookMyShow.entity.Owner;
import com.jsp.CloneAPIBookMyShow.service.OwnerService;
import com.jsp.CloneAPIBookMyShow.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
@Autowired
private OwnerService ownerService;

@ApiOperation(value = "save Owner",notes = "api used to save owner")
@ApiResponses(value = {@ApiResponse(code = 201,message = "Owner saved successfully"),@ApiResponse(code = 404,message = "Owner dosen't saved ,please enter valid details")})
@PostMapping
public ResponseEntity<ResponseStructure<OwnerDto>>	 saveOwner(@RequestBody Owner owner) {
	return ownerService.saveOwner(owner);
}

@ApiOperation(value = "update Owner",notes = "api used to update owner")
@ApiResponses(value = {@ApiResponse(code = 200,message = "Owner updated successfully"),@ApiResponse(code = 404,message = "Owner dosen't updated ,please enter valid details")})
@PutMapping
public ResponseEntity<ResponseStructure<OwnerDto>> updateOwner(@RequestParam long ownerId,@RequestBody Owner owner) {
	return ownerService.updateOwner(ownerId, owner);
}

@ApiOperation(value = "get Owner",notes = "api used to get owner")
@ApiResponses(value = {@ApiResponse(code = 301,message = "Owner get successfully"),@ApiResponse(code = 404,message = "Owner dosen't get ,please enter valid details")})

@DeleteMapping
public ResponseEntity<ResponseStructure<OwnerDto>> deleteOwnerById(@RequestParam long ownerId) {
	return ownerService.deleteOwnerBYId(ownerId);
}

@ApiOperation(value = "delete Owner",notes = "api used to delete owner")
@ApiResponses(value = {@ApiResponse(code = 200,message = "Owner delete successfully"),@ApiResponse(code = 404,message = "Owner dosen't delete ,please enter valid details")})

 @GetMapping
public ResponseEntity<ResponseStructure<OwnerDto>>  findOwnerById(@RequestParam long ownerId) {
	return ownerService.findOwnerById(ownerId);

}
}
