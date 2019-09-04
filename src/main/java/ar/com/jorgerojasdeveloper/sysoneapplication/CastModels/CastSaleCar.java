package ar.com.jorgerojasdeveloper.sysoneapplication.CastModels;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.jorgerojasdeveloper.sysoneapplication.business.SaleCarBusiness;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.SaleCar;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.SaleCarModel;

@Component
public class CastSaleCar {
	@Autowired
	CastOptionalPart castOp;
	
	@Autowired
	SaleCarBusiness scb;

	@Autowired
	CastCar castCar;

	public List<SaleCarModel> entityToModelList(List<SaleCar> salecars) {
		return salecars.stream().map(item -> this.entityToModel(item)).collect(Collectors.toList());
	}

	public SaleCarModel entityToModel(SaleCar salecar) {
		SaleCarModel model = new SaleCarModel();

		model.setId(salecar.getId());
		model.setTotalPrice(salecar.getTotalPrice());
		model.setListOptionalParts(castOp.entityToModelList(salecar.getListOptionalParts()));
		model.setCar(castCar.entityToModel(salecar.getCar()));

		return model;
	}

}
