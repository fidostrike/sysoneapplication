package ar.com.jorgerojasdeveloper.sysoneapplication;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.jorgerojasdeveloper.sysoneapplication.business.SaleCarBusiness;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.Car;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.OptionalPart;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.CarService;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.OptionalPartService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysoneapplicationApplicationTests {
	@Autowired
	CarService carService;
	
	@Autowired
	OptionalPartService opService;
	
	@Autowired
	SaleCarBusiness sc;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCalculateTotalPrice()
	{
		Car car = carService.getOne(1);
		List<OptionalPart> lstOp = opService.findAll();
		
		float total = sc.getTotalPrice(car, lstOp);
		assertThat(295000f).isEqualTo(total);
		
	}

}
