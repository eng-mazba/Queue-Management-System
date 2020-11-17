package com.example.qms.reposetory;

import com.example.qms.model.Teller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TellerRepository extends JpaRepository<Teller, String> {

}
