package ar.com.jorgerojasdeveloper.sysoneapplication.models;

import io.swagger.annotations.ApiModel;

@ApiModel("Model optional part")
public class OptionalPartModel{
	private Integer id;
	private String name;
	private float price;
	private String abbrev;

	public OptionalPartModel() {
		super();
	}

	public OptionalPartModel(String name, float price, String abbrev) {
		super();
		this.name = name;
		this.price = price;
		this.abbrev = abbrev;
	}

	public OptionalPartModel(Integer id, String name, float price, String abbrev) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.abbrev = abbrev;
	}

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
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
