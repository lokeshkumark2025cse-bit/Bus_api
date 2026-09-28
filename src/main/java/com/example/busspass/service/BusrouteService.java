package com.example.busspass.service;

import com.example.busspass.model.Busroute;

public interface BusrouteService {
        Busroute savBusroute(Busroute busroute);
        Busroute getBusroutebyId(Long id);
}
