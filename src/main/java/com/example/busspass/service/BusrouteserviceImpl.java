package com.example.busspass.service;

import com.example.busspass.model.Busroute;
import com.example.busspass.repo.Busrouterepo;
import org.springframework.stereotype.Service;

@Service
public class BusrouteserviceImpl implements BusrouteService {
    private final Busrouterepo busrouterepo;

public BusrouteserviceImpl(Busrouterepo busrouterepo)
{
    this.busrouterepo=busrouterepo;
}

  @Override
  public Busroute savBusroute(Busroute busroute)
  {
    return busrouterepo.save(busroute);
  } 

  @Override 
  public Busroute getBusroutebyId(Long id)
  {
    return busrouterepo.findById(id).orElse(null);
  }
}
