package com.demotest.test.repository;

import com.demotest.test.model.City;
import com.demotest.test.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepo extends JpaRepository<State, Integer> {


}
