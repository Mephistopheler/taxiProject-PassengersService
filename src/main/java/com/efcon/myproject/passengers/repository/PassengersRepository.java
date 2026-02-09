package com.efcon.myproject.passengers.repository;

import com.efcon.myproject.passengers.model.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Long> {

    Passengers findByEmail(String email);

}
