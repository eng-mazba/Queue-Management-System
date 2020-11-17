package com.example.qms.reposetory;

import com.example.qms.model.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.temporal.TemporalAmount;
import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
     Users findByIdAndPassword(String id, String password);
     Users findByUserNameAndPassword(String uname, String password);

     @Query("select u from Users u order by u.id")
     List<Users> findTopById();

}
