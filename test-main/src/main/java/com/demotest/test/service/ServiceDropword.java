package com.demotest.test.service;

import com.demotest.test.model.City;
import com.demotest.test.model.State;
import com.demotest.test.repository.CityRepo;
import com.demotest.test.repository.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDropword {

    @Autowired
    CityRepo cityRepo;

    @Autowired
    Village village;

    public List<State> findAllCity(){
        return cityRepo.findAll();
    }

    public List<City> findCityById(int id){
        return village.findByStateId(id);
    }
}
