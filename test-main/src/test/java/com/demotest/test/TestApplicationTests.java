package com.demotest.test;

import com.demotest.test.model.City;
import com.demotest.test.repository.Village;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	Village village;

	@Test
	void x(){
		List<City> s = village.findByStateId(2);
		for (City c:s) {
			System.out.println(c.getCt_name());
		}

	}

	@Test
	void contextLoads() {
	}

}
