package com.nk.message.entity;

import java.util.Collections;
import java.util.List;
//import com.nk.message.entity.Message;

public class MessageResponse {
	private List<MessageEntity> chat;

	public MessageResponse(List<MessageEntity> chat){
      this.chat = chat;
      }
  
	public MessageResponse(MessageEntity chat){
	  List<MessageEntity> chatlist = Collections.singletonList(chat);
      this.chat = chatlist;
      }

	public List<MessageEntity> getChat() {
		return chat;
	}

	public void setChat(List<MessageEntity> chat) {
		this.chat = chat;
	}
  

}
