package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public interface CarService {
    public  List<Car> listAllCars();
}
