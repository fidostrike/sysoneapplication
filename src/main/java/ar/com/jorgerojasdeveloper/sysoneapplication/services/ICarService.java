package ar.com.jorgerojasdeveloper.sysoneapplication.services;

import java.util.List;

import ar.com.jorgerojasdeveloper.sysoneapplication.entities.Car;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.CarModel;

public interface ICarService {
	public List<CarModel> getAllCarsModels();

	public CarModel getCarModel(Integer id);

	public Car getOne(Integer id);

	public <S extends Car> S save(S entity);

	public void deleteById(Integer id);
}
