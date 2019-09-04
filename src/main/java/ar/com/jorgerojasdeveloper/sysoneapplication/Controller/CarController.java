package ar.com.jorgerojasdeveloper.sysoneapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.CarModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Car controller", description = "This API is to find cars")
@RestController
@RequestMapping(path="/car")
public class CarController {
	@Autowired
	CarService carService;
	
	@ApiOperation(value = "Find cars", notes = "Return all list of cars")
	@GetMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<CarModel> listCars(){
        return carService.getAllCarsModels();
    }
	
	@ApiOperation(value = "Find car", notes = "Return card by id")
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public CarModel getCar(@PathVariable Integer id){
        return carService.getCarModel(id);
    }
	
}
