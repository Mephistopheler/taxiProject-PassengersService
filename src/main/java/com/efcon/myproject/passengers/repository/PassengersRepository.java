package com.efcon.myproject.passengers.repository;

import com.efcon.myproject.passengers.model.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Long> {

    Optional<Passengers> findByEmailAndDeletedFalse(String email);

    Optional<Passengers> findByIdAndDeletedFalse(Long id);

    List<Passengers> findAllByDeletedFalse();

}
