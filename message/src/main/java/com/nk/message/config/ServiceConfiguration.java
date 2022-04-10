package com.nk.message.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.ArrayList;
import java.util.Arrays;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.jms.annotation.EnableJms;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.nk.message.services.sendMessage;

@Configuration
@EnableWebSocket
public class ServiceConfiguration {
	
 @Value("${active-mq.broker-url}")
 private String brokerUrl;
  @Bean
//  @LoadBalanced
  public RestTemplate loadBalancedRestTemplate() {
      return new RestTemplate();
  }
  
  @Bean
  public ConnectionFactory connectionFactory(){
      ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
      activeMQConnectionFactory.setBrokerURL(brokerUrl);
      activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.mailshine.springbootstandaloneactivemq"));
      return  activeMQConnectionFactory;
  }

  
  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
      DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
      factory.setConnectionFactory(connectionFactory());
      factory.setPubSubDomain(true);
      return factory;
  }
  
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
      registry.addHandler(new sendMessage(), "/socket.io");
      System.out.print(registry);
      
  }
  
}


