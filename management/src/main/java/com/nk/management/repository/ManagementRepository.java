package com.nk.management.repository;

import com.nk.management.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ManagementRepository extends CrudRepository<management, Long>{
//	List<Message> findAll();

	  @Query(nativeQuery=true,
			  value="select case when exists(select * from management where user_id like ?1 and group_id like ?2) then true else false end")
//	  select case when exists(select m from management m where m.userId like ?1 and m.groupId like ?2) then 'true' else 'false' end"
	  boolean verifyUser(long userId, long groupId);
}
