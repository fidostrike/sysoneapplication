package ar.com.jorgerojasdeveloper.sysoneapplication.models;

import io.swagger.annotations.ApiModel;

@ApiModel("Model car")
public class CarModel {
	private Integer id;
	private String name;
	private float price;
	
	public CarModel() {
		super();
	}

	public CarModel(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public CarModel(Integer id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
