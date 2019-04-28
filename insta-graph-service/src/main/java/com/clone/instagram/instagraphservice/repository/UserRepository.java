package com.clone.instagram.instagraphservice.repository;

import com.clone.instagram.instagraphservice.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    @Query("MATCH (n)-[r]->() where n.username={0} RETURN COUNT(r)")
    Long findOutDegree(String username);

    @Query("MATCH (n)<-[r]-() where n.username={0} RETURN COUNT(r)")
    Long findInDegree(String username);
}
