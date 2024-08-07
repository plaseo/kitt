package com.cardealer.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cardealer.models.Car;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {

    @Query(value = "select exists(select 1 from car where vin = ?1)", nativeQuery = true)
    public boolean existsByVIN(String vin);

    @Query(value = "select * from car where model = ?1", nativeQuery = true)
    public List<Car> findCarByModel(String model);
    
}
