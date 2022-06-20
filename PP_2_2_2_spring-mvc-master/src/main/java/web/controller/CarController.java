package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.dao.CarDAO;


@Controller
public class CarController {
    private CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String index(Model model) {
        if (carDAO.index() == null) {
            throw new NullPointerException("Not data exists!");
        }
        model.addAttribute("cars", carDAO.index());
        return "index";
    }

    @GetMapping("/cars/{count}")
    public String showCars(@PathVariable int count, Model model) {
        if (count < 0) {
            throw new RuntimeException("Pathing variable must be positive");
        } else if (count > carDAO.index().size()) {
            throw new RuntimeException("Pathing variable is too big");
        }
        model.addAttribute("cars", carDAO.showCars(count));
        return "index";
    }
}
