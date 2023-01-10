package org.idb.emf.EMFCourier;

import org.idb.emf.EMFCourier.entity.ParcelDetails;
import org.idb.emf.EMFCourier.entity.RecipientDetails;
import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.idb.emf.EMFCourier.service.ParcelDetailsService;
import org.idb.emf.EMFCourier.service.RecipientDetailsService;
import org.idb.emf.EMFCourier.service.SenderDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmfCourierApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	ParcelDetailsService service;

	@Test
	void testEmpSave(){
		ParcelDetails e=new ParcelDetails();
		e.setSelectProductType("mango");
		e.setPackageWeight(2.0);
		e.setNumberOfItem("Pabna");
		e.setWhatDoesThisParcelContain("mirpur");


		service.saveParcelDetails(e);

	}

	@Test
	void TestDelEmp(){
		service.deleteParcelDetails(1);
	}

	@Test
	void TestListEmp(){
		ParcelDetails e=service.findParcelDetailsById(2);
		e.setSelectProductType("File");
		service.saveParcelDetails(e);
		System.out.println(e);
	}


}
