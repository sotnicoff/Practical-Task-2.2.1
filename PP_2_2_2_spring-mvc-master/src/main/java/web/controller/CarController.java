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
        model.addAttribute("cars", carDAO.index());
        return "index";
    }

    @GetMapping("/cars/{count}")
    public String showCars(@PathVariable int count, Model model) {
        model.addAttribute("cars", carDAO.showCars(count));
        return "index";
    }
}
