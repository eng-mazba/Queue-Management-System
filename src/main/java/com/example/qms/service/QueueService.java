package com.example.qms.service;

import com.example.qms.model.Queues;

import java.util.List;

public interface QueueService {

    List<Queues> findAllProcessTokens();

    Queues findTopTokenById(String counterNo);

    List<Queues> findWaitingToken();

    String save(Queues queues);

    Queues findById(Long id);

}
