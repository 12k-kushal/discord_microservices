package com.nk.message.repository;

import com.nk.message.entity.Message;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long>{
	List<Message> findAll();

	
}

