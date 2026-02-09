package com.efcon.myproject.passengers.service;

import com.efcon.myproject.passengers.model.Passengers;
import com.efcon.myproject.passengers.repository.PassengersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengersService {

    private final PassengersRepository passengersRepository;




    public Passengers savePassenger(Passengers passengers){

        return  passengersRepository.save(passengers);

    };

    public List<Passengers> findAllPassengers(){

        return passengersRepository.findAll();

    };

    public Optional<Passengers> findPassengerById(long id) {
        return passengersRepository.findById(id);
    }

}
