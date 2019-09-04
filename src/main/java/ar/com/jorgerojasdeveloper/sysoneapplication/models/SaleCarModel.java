package ar.com.jorgerojasdeveloper.sysoneapplication.models;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel("Model sale car")
public class SaleCarModel{
	private Integer id;

	private float totalPrice;

	private List<OptionalPartModel> listOptionalParts = new ArrayList<OptionalPartModel>();

	private CarModel car;

	public SaleCarModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OptionalPartModel> getListOptionalParts() {
		return listOptionalParts;
	}

	public void setListOptionalParts(List<OptionalPartModel> listOptionalParts) {
		this.listOptionalParts = listOptionalParts;
	}

	public CarModel getCar() {
		return car;
	}

	public void setCar(CarModel car) {
		this.car = car;
	}
		
}
