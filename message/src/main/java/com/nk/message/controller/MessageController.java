package com.nk.message.controller;

import com.nk.message.entity.MessageResponse;
import com.nk.message.repository.MessageRepository;
import com.nk.message.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MessageController {
	@Autowired
    MessageRepository messageRepository;
	
    @GetMapping("/get-message")
    public MessageResponse getAllMessage(){
//        System.out.println(externalConfig.getName());
        return new MessageResponse(messageRepository.findAll());
    }
    
	@PostMapping("/post-message")
	public MessageResponse postMessage(@RequestBody Message message) {
		return new MessageResponse(messageRepository.save(message));
	}
	
}
