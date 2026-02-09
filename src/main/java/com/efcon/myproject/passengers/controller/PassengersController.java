package com.efcon.myproject.passengers.controller;


import com.efcon.myproject.passengers.model.Passengers;
import com.efcon.myproject.passengers.service.PassengersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengersController {

    private final PassengersService passengersService;




    @PostMapping
    public ResponseEntity<Passengers> createPassenger(@RequestBody Passengers passenger){

        Passengers savedPassenger = passengersService.savePassenger(passenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);

    };

    @GetMapping
    public ResponseEntity<List<Passengers>> findAllPassengers() {
        List<Passengers> passengers = passengersService.findAllPassengers();
        System.out.println(passengers);
        return ResponseEntity.ok(passengers);
    }

}
