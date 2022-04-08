package com.nk.management.controller;

import org.springframework.web.bind.annotation.RestController;
import com.nk.management.assembler.ManagementAssembler;
import com.nk.management.entity.MessageResponse;
import com.nk.management.repository.ManagementRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ManagementController {
	@Autowired
    ManagementRepository managementRepository;
	
	@Autowired
	ManagementAssembler assembler;
	
    @GetMapping("/verify/{user_id}/{group_id}")
    public boolean verifyUser(@PathVariable("group_id") String groupId, @PathVariable("user_id") String userId){
    	long newGroupId = Long.parseLong(groupId);
    	long newUserId = Long.parseLong(userId);
    	return managementRepository.verifyUser(newUserId, newGroupId);
    }
    
    
}
