package com.example.qms.service;

import com.example.qms.model.Queues;
import com.example.qms.reposetory.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QueueServiceImpl implements QueueService {

    @Autowired
    QueueRepository queueRepository;

    @Override
    public List<Queues> findAllProcessTokens() {
        return queueRepository.findAllProcessTokens();
    }

    @Override
    public Queues findTopTokenById(String counterNo) {
        return queueRepository.findTopTokenById(counterNo);
    }

    @Override
    public List<Queues> findWaitingToken() {
        return queueRepository.findWaitingToken();
    }

    @Override
    public String save(Queues queues) {
        Queues dbqueues = queueRepository.save(queues);
        return dbqueues.getTokenNo();
    }

    @Override
    public Queues findById(Long id) {
        return queueRepository.findById(id).get();
    }


}
