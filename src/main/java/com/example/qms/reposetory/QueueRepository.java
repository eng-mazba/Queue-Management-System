package com.example.qms.reposetory;

import com.example.qms.model.Queues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface QueueRepository extends CrudRepository<Queues, Long>, QueueCustomRepository {

}
