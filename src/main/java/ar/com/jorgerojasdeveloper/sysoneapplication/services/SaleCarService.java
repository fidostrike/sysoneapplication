package ar.com.jorgerojasdeveloper.sysoneapplication.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.jorgerojasdeveloper.sysoneapplication.CastModels.CastSaleCar;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.SaleCar;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.SaleCarModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.repositories.ISaleCarRepository;

@Service
public class SaleCarService implements ISaleCarService {
	@Autowired
	ISaleCarRepository saleCarRep;
	
	@Autowired
	CastSaleCar castSaleCar;

	public List<SaleCarModel> getAllSaleCars() {
		return castSaleCar.entityToModelList((List<SaleCar>)saleCarRep.findAll());
	}

	public SaleCarModel getSaleCar(Integer id) {
		return castSaleCar.entityToModel((saleCarRep.getOne(id)));
	}
	
	public SaleCarModel getByCar(Integer id) {
		return castSaleCar.entityToModel((saleCarRep.findByCarId(id)));
	}
	
	@Transactional
	public <S extends SaleCar> S save(S entity) {
		return saleCarRep.save(entity);
	}
	
	public void deleteById(Integer id) {
		saleCarRep.deleteById(id);
	}
	
	public SaleCar findByCarId(Integer car_id) {
		return saleCarRep.findByCarId(car_id);
	}
	
}
