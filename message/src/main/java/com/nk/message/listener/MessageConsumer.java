package com.nk.message.listener;


import org.apache.activemq.command.ActiveMQBytesMessage;
//
//public class MessageConsumer {
//
//}
//import com.mailshine.springbootstandaloneactivemq.model.Employee;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.nk.message.entity.MessageEntity;
import com.nk.message.services.*;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;



@Component
//@Slf4j
public class MessageConsumer implements MessageListener {

	@Autowired private sendMessage sendMessage;

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
        	ActiveMQBytesMessage  amqMessage  = (ActiveMQBytesMessage)message;            
            System.out.println(amqMessage.readUTF());
            System.out.println("send message to ws");

        	sendMessage.echo(amqMessage.readUTF());

        } catch(Exception e) {
//          log.error("Received Exception : "+ e);
        	System.out.println(e);
        }

    }
}