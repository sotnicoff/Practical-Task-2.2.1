package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CarDAO {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", "Q8", "Black"));
        cars.add(new Car("Ford", "Mustang", "Grey"));
        cars.add(new Car("BMW", "X5", "Dark Green"));
        cars.add(new Car("Toyota", "Land Cruiser", "Black"));
        cars.add(new Car("Mitsubishi", "Outlander XL", "Blue"));
    }

    public List<Car> index() {
        if (cars == null) {
            return null;
        }
        return cars;
    }

    public List<Car> showCars(int count) {
        if (count >= 5 || count < 0 || count > cars.size()) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
