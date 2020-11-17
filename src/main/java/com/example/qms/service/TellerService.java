package com.example.qms.service;

import com.example.qms.model.Teller;

import java.util.List;

public interface TellerService {
    List<Teller> findAll();
    void save(Teller teller);
    Teller findById(String id);
}
