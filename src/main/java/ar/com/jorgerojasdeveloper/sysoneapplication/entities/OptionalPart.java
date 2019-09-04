package ar.com.jorgerojasdeveloper.sysoneapplication.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "optionalpart")
public class OptionalPart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "op_generator")
	@SequenceGenerator(name="op_generator", sequenceName = "OP_SEQ", allocationSize=50)
	private Integer id;

	@Column(length = 50)
	private String name;

	private float price;

	@Column(length = 5,unique=true)
	private String abbrev;

	public OptionalPart() {
		super();
	}

	public OptionalPart(String name, float price, String abbrev) {
		super();
		this.name = name;
		this.price = price;
		this.abbrev = abbrev;
	}

	public OptionalPart(Integer id, String name, float price, String abbrev) {
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
