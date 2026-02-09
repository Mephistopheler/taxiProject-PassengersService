package com.efcon.myproject.passengers.controller;


import com.efcon.myproject.passengers.dto.PassengerDto;
import com.efcon.myproject.passengers.model.Passengers;
import com.efcon.myproject.passengers.service.PassengersService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;


@RestController()
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengersController {

    private final PassengersService passengersService;




    @PostMapping
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto){

        Passengers savedPassenger = passengersService.savePassenger(toEntity(passengerDto));
        return new ResponseEntity<>(toDto(savedPassenger), HttpStatus.CREATED);


    };

    @GetMapping
    public ResponseEntity<List<PassengerDto>> findAllPassengers() {
        List<PassengerDto> passengers = passengersService.findAllPassengers()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        System.out.println(passengers);
        return ResponseEntity.ok(passengers);
    }

    private Passengers toEntity(PassengerDto passengerDto) {
        Passengers passenger = new Passengers();
        passenger.setId(passengerDto.getId());
        passenger.setName(passengerDto.getName());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setPhone(passengerDto.getPhone());
        return passenger;
    }

    private PassengerDto toDto(Passengers passenger) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setId(passenger.getId());
        passengerDto.setName(passenger.getName());
        passengerDto.setEmail(passenger.getEmail());
        passengerDto.setPhone(passenger.getPhone());
        return passengerDto;
    }

}
