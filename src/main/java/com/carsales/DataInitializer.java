package com.carsales;

import com.carsales.model.Car;
import com.carsales.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) {
        if (carRepository.count() == 0) {
            carRepository.save(new Car("Toyota", "Corolla", 2020, new BigDecimal("18500"), "Bleu", 45000, "Berline fiable et économique, entretien régulier effectué."));
            carRepository.save(new Car("BMW", "X5", 2022, new BigDecimal("55000"), "Noir", 15000, "SUV de luxe, plein options, comme neuf."));
            carRepository.save(new Car("Renault", "Clio", 2021, new BigDecimal("14500"), "Rouge", 30000, "Citadine idéale pour la ville, faible consommation."));
            carRepository.save(new Car("Mercedes", "Classe C", 2023, new BigDecimal("42000"), "Blanc", 8000, "Berline premium, finition AMG, intérieur cuir."));
            carRepository.save(new Car("Volkswagen", "Golf", 2019, new BigDecimal("19500"), "Gris", 60000, "Compacte polyvalente, excellent état."));
            carRepository.save(new Car("Audi", "A3", 2022, new BigDecimal("32000"), "Argent", 12000, "Berline sportive, faible kilométrage, garantie."));
        }
    }
}
