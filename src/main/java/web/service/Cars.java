package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class Cars implements CarService  {
    static List<Car> cars = new ArrayList<>();
    {
        cars.add(new Car("BMW", 2011, "Red"));
        cars.add(new Car("Audi", 2012, "Blue"));
        cars.add(new Car("Mercedes", 2013, "Black"));
        cars.add(new Car("Toyota", 1411, "Yellow"));
        cars.add(new Car("Honda", 2015, "Orange"));
    }

    @Override
    public List<Car> listAllCars() {
        return cars;
    }
}
