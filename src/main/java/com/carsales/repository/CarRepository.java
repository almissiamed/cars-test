package com.carsales.repository;

import com.carsales.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrandContainingIgnoreCase(String brand);
    List<Car> findByModelContainingIgnoreCase(String model);
    List<Car> findByYearBetween(int minYear, int maxYear);
    List<Car> findByPriceBetween(java.math.BigDecimal minPrice, java.math.BigDecimal maxPrice);
}
