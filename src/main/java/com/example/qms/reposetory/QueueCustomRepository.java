package com.example.qms.reposetory;

import com.example.qms.model.Queues;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueueCustomRepository {
    Queues findTopTokenById(String counterNo);

    @Query("select q from Queues q where q.status = 2 order by q.tokenNo desc")
    List<Queues> findAllProcessTokens();

    @Query("select q from Queues q where q.status = 1 order by q.id asc")
    List<Queues> findWaitingToken();
}
