package com.demotest.test.repository;

import com.demotest.test.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Village extends JpaRepository<City, Integer> {


    @Query("select c from City c inner JOIN c.state s where s.id = ?1")
    public List<City> findByStateId(int id);
}
