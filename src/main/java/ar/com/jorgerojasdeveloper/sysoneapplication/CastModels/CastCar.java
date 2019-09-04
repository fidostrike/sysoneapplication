package ar.com.jorgerojasdeveloper.sysoneapplication.CastModels;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.Car;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.CarModel;

@Component
public class CastCar {
	@Autowired
	CastOptionalPart cop;

	public List<CarModel> entityToModelList(List<Car> cars) {
		return cars.stream().map(item -> this.entityToModel(item)).collect(Collectors.toList());
	}

	public CarModel entityToModel(Car car) {
		CarModel model = new CarModel();

		model.setId(car.getId());
		model.setName(car.getName());
		model.setPrice(car.getPrice());

		return model;

	}
}
