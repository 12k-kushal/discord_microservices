package com.nk.message.repository;

import com.nk.message.entity.MessageEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MessageRepository extends CrudRepository<MessageEntity, Long>{
	List<MessageEntity> findAll();

	  @Query("select m from MessageEntity m where m.groupId like ?1")
	  List<MessageEntity> findByGroupId(long groupId);
}
