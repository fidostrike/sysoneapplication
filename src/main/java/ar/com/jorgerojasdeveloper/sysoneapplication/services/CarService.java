package ar.com.jorgerojasdeveloper.sysoneapplication.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.jorgerojasdeveloper.sysoneapplication.CastModels.CastCar;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.Car;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.CarModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.repositories.ICarRepository;

@Service
public class CarService implements ICarService {
	@Autowired
	ICarRepository carRep;
	
	@Autowired
	CastCar castCar;

	public List<CarModel> getAllCarsModels() {
		return castCar.entityToModelList((List<Car>)carRep.findAll());
	}

	public CarModel getCarModel(Integer id) {
		return castCar.entityToModel((carRep.getOne(id)));
	}
	
	public Car getOne(Integer id) {	
		Car result = null;
		Optional<Car> res = carRep.findById(id);
		
		try
		{
			result = res.get();
		}
		catch (Exception e) {
			
		}
		
		return result;
	}
	
	public <S extends Car> S save(S entity) {
		return carRep.save(entity);
	}
	
	public void deleteById(Integer id) {
		carRep.deleteById(id);
	}

}
