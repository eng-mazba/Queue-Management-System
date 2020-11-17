package com.example.qms.reposetory;

import com.example.qms.model.Queues;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class QueueCustomRepositoryImpl implements QueueCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Queues findTopTokenById(String cntrNo) {
        TypedQuery<Queues> query = entityManager.createQuery("select q from Queues q where q.status =1 or (q.status =2 and q.counterNo = ?1) order by q.id asc", Queues.class);
       return query.setParameter(1, cntrNo).setMaxResults(1).getSingleResult();
    }

    @Override
    public List<Queues> findAllProcessTokens() {
        return null;
    }

    @Override
    public List<Queues> findWaitingToken() {
        return null;
    }
}

