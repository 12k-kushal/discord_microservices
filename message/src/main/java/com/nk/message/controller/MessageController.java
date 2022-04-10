package com.nk.message.controller;

import com.nk.message.entity.MessageResponse;
import com.nk.message.repository.MessageRepository;
import com.nk.message.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {
	@Autowired
    MessageRepository messageRepository;
	
    @Autowired
    private RestTemplate restTemplate;
	
    @GetMapping("/get-message/{user_id}/{group_id}")
    public MessageResponse getAllMessage(@PathVariable("group_id") String groupId, @PathVariable("user_id") String userId){
//    	System.out.println(groupId);
//    	System.out.println(userId);

    	String management_url = "http://localhost:9080/verify";
        ResponseEntity<Boolean> status  = restTemplate.exchange(management_url,
                HttpMethod.GET,null,boolean.class);
    	System.out.println(status);
    	long newGroupId = Long.parseLong(groupId);
    	
        return new MessageResponse(messageRepository.findByGroupId(newGroupId));
    }
    
    
    
	@PostMapping("/post-message")
	public MessageResponse postMessage(@RequestBody MessageEntity message) {
		
    	String management_url = "http://localhost:9080/verify";
        ResponseEntity<Boolean> status  = restTemplate.exchange(management_url,
                HttpMethod.GET,null,boolean.class);
        
		return new MessageResponse(messageRepository.save(message));
	}
	
	
	
}
