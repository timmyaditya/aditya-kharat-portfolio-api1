package org.timmyaditya.adityaPortfolioJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.timmyaditya.adityaPortfolioJpa.model.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Integer> {
	List<MessageModel> findByName(String name);
	
	@Query("from MessageModel m where m.name = name order by timestamp")
	List<MessageModel> selectAllDataByName(@Param("name") String name);
	
	@Query("from MessageModel m order by m.timestamp")
	List<MessageModel> selectAllData();
}
