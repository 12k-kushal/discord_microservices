package com.nk.message.repository;

import com.nk.message.entity.Message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long>{
	List<Message> findAll();

	  @Query("select m from Message m where m.groupId like ?1")
	  List<Message> findByGroupId(long groupId);
}
