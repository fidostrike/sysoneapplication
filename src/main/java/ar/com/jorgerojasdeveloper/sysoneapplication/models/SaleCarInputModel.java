package ar.com.jorgerojasdeveloper.sysoneapplication.models;

import io.swagger.annotations.ApiModel;

@ApiModel("Model sale car input")
public class SaleCarInputModel {
	Integer carId;
	String[] optionalParts = new String[0];

	public SaleCarInputModel() {
		super();
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String[] getOptionalParts() {
		return optionalParts;
	}

	public void setOptionalParts(String[] optionalParts) {
		this.optionalParts = optionalParts;
	}

}
