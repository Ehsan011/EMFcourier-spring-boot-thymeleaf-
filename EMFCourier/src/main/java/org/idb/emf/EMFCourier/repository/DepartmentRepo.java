package org.idb.emf.EMFCourier.repository;


import org.idb.emf.EMFCourier.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
