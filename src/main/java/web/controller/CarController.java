package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.Cars;

import java.util.List;

@Controller
public class    CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) {
            count = 5;
        }
        List<Car> cars = carService.listAllCars(count);
        System.out.println(cars);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
