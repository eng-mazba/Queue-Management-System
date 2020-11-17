package com.example.qms.service;

import com.example.qms.model.Teller;
import com.example.qms.reposetory.TellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TellerServiceImpl implements TellerService {

    @Autowired
    TellerRepository tellerRepository;

    @Override
    public List<Teller> findAll() {
        return tellerRepository.findAll();
    }

    @Override
    public void save(Teller teller) {
        tellerRepository.save(teller);
    }


    @Override
    public Teller findById(String id) {
        return tellerRepository.findById(id).get();
    }
}
