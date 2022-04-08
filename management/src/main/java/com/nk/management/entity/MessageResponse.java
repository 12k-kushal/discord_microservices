package com.nk.management.entity;

import java.util.Collections;
import java.util.List;

public class MessageResponse {
	private List<Message> chat;

	public MessageResponse(List<Message> chat){
      this.chat = chat;
      }
  
	public MessageResponse(Message chat){
	  List<Message> chatlist = Collections.singletonList(chat);
      this.chat = chatlist;
      }

	public List<Message> getChat() {
		return chat;
	}

	public void setChat(List<Message> chat) {
		this.chat = chat;
	}
  

}
