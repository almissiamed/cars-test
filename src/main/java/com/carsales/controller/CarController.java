package com.carsales.controller;

import com.carsales.model.Car;
import com.carsales.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "cars/list";
    }

    @GetMapping("/{id}")
    public String carDetail(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.findById(id));
        return "cars/detail";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("car", new Car());
        return "cars/form";
    }

    @PostMapping
    public String createCar(@Valid @ModelAttribute Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "cars/form";
        }
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.findById(id));
        return "cars/form";
    }

    @PostMapping("/{id}")
    public String updateCar(@PathVariable Long id, @Valid @ModelAttribute Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "cars/form";
        }
        car.setId(id);
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/delete")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }
}
