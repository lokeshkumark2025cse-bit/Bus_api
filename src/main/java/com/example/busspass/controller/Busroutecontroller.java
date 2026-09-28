package com.example.busspass.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busspass.model.Busroute;
import com.example.busspass.service.BusrouteService;

@RestController
@RequestMapping("/routes")
public class Busroutecontroller {

    private BusrouteService busRouteService;

    public Busroutecontroller(BusrouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @PostMapping
    public Busroute saveBusRoute(@RequestBody Busroute busroute) {
        return busRouteService.savBusroute(busroute);
    }

    @GetMapping("/{routeid}")
    public Busroute getBusRouteById(@PathVariable Long id) {
        return busRouteService.getBusroutebyId(id);
    }
}