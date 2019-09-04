package ar.com.jorgerojasdeveloper.sysoneapplication.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "salecar")
public class SaleCar implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sc_generator")
	@SequenceGenerator(name="sc_generator", sequenceName = "SC_SEQ", allocationSize=50)
	private Integer id;

	private float totalPrice;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "salecar_optionalpart", joinColumns = @JoinColumn(name = "SC_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "OP_id", referencedColumnName = "id"))
	private List<OptionalPart> listOptionalParts = new ArrayList<OptionalPart>();

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Car car;

	public SaleCar() {
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

	public List<OptionalPart> getListOptionalParts() {
		return listOptionalParts;
	}

	public void setListOptionalParts(List<OptionalPart> listOptionalParts) {
		this.listOptionalParts = listOptionalParts;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
		
}
