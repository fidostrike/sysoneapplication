package ar.com.jorgerojasdeveloper.sysoneapplication.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "car")
public class Car implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_generator")
	@SequenceGenerator(name="car_generator", sequenceName = "CAR_SEQ", allocationSize=50)
	private Integer id;

	@Column(length = 50,unique=true)
	private String name;

	private float price;

	public Car() {
		super();
	}

	public Car(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Car(Integer id, String name, float price) {
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
