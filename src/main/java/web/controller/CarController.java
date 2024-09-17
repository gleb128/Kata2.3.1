package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.Cars;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String showCars(Model model) {
        List<Car> cars = carService.listAllCars();
        model.addAttribute("cars", cars);
        return "cars";
    }
}
