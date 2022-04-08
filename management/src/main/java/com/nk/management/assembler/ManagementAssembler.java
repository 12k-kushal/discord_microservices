package com.nk.management.assembler;

import com.nk.management.entity.Message;
import com.nk.management.entity.MessageResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ManagementAssembler {
	
    @Autowired
    private RestTemplate restTemplate;
    
    private static final String MESSAGE_SERVICE_ID = "messageApp";
    private static final String MESSAGE_ENDPOINT = "/get-message";
    
    public ResponseEntity<MessageResponse> getMessages(){
        ResponseEntity<MessageResponse> messageResponse = restTemplate.exchange(getServiceURL(MESSAGE_SERVICE_ID,MESSAGE_ENDPOINT),
                HttpMethod.GET,null,MessageResponse.class);
		return messageResponse;
	}


    private String getServiceURL(String serviceId,String serviceEndpoint){
        return new StringBuffer("http://").append(serviceId)
                .append(serviceEndpoint).toString();
    }
}
