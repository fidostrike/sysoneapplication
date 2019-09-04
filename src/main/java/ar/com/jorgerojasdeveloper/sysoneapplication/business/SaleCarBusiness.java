package ar.com.jorgerojasdeveloper.sysoneapplication.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import ar.com.jorgerojasdeveloper.sysoneapplication.CastModels.CastSaleCar;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.Car;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.OptionalPart;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.SaleCar;
import ar.com.jorgerojasdeveloper.sysoneapplication.exceptions.NotCarFound;
import ar.com.jorgerojasdeveloper.sysoneapplication.exceptions.NotOptionalPartFound;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.SaleCarInputModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.SaleCarModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.CarService;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.OptionalPartService;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.SaleCarService;

@Component
public class SaleCarBusiness {
	@Autowired
	SaleCarService saleCarService;

	@Autowired
	OptionalPartService opService;

	@Autowired
	CarService carService;
	
	@Autowired
	CastSaleCar castSaleCar;

	public void setSaleCardTotalPrice(SaleCar saleCar) {
		saleCar.setTotalPrice(getTotalPrice(saleCar.getCar(), saleCar.getListOptionalParts()));
	}

	public float getTotalPrice(Car car, List<OptionalPart> lstOp) {
		float result = 0f;

		result += car.getPrice();

		for (OptionalPart optionalPart : lstOp) {
			result += optionalPart.getPrice();
		}

		return result;
	}

	public ResponseEntity<?> update(SaleCarInputModel sci) {
		ResponseEntity<?> result = null;
		
		SaleCar scm = null;

		// valid exist salecar
		scm = saleCarService.findByCarId(sci.getCarId());

		if (scm == null) {
			scm = new SaleCar();
		}

		try
		{
			scm = updateEntity(sci, scm);			
			SaleCarModel model = castSaleCar.entityToModel(scm);
			result = new ResponseEntity<>(model, HttpStatus.CREATED);
		}
		catch (NotOptionalPartFound e) {
			result = NotOptionalPartFound.getResponse();
		}
		catch (NotCarFound e) {
			result = NotCarFound.getResponse();
		}
		
		return result;
	}

	public SaleCar updateEntity(SaleCarInputModel sci, SaleCar result) throws NotOptionalPartFound,NotCarFound {
		// valid exist car
		Car car = carService.getOne(sci.getCarId());
		
		if (car!=null) {
			result.setCar(car);
			result.getListOptionalParts().clear();
			
			for (String item : sci.getOptionalParts()) {
				OptionalPart op = opService.findByAbbrev(item);
				
				if(op!=null)
				{
					result.getListOptionalParts().add(op);
				}
				else
				{
					throw new NotOptionalPartFound();
				}
			}
			
			setSaleCardTotalPrice(result);
			
			saleCarService.save(result);
			
		} else {
			throw new NotCarFound();
		}
		
		return result;
	}

}
