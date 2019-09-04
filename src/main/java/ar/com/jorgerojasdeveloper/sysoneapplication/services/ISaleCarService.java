package ar.com.jorgerojasdeveloper.sysoneapplication.services;

import java.util.List;

import ar.com.jorgerojasdeveloper.sysoneapplication.entities.SaleCar;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.SaleCarModel;

public interface ISaleCarService {
	public List<SaleCarModel> getAllSaleCars();

	public SaleCarModel getSaleCar(Integer id);

	public SaleCarModel getByCar(Integer id);

	public <S extends SaleCar> S save(S entity);

	public void deleteById(Integer id);
	
	public SaleCar findByCarId(Integer car_id);
}
