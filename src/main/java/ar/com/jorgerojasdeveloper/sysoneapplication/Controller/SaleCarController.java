package ar.com.jorgerojasdeveloper.sysoneapplication.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.jorgerojasdeveloper.sysoneapplication.business.SaleCarBusiness;
import ar.com.jorgerojasdeveloper.sysoneapplication.exceptions.CustomJsonParseException;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.SaleCarInputModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.SaleCarModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.SaleCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@Api(value = "SaleCar controller", description = "This API has a crud for sale cars")
@RestController
@RequestMapping(path = "/salecar")
public class SaleCarController {
	@Autowired
	SaleCarService scService;

	@Autowired
	SaleCarBusiness scb;

	@ApiOperation(value = "Find sale cars", notes = "Return all list of sale cars")
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SaleCarModel> listSaleCars() {
		return scService.getAllSaleCars();
	}

	@ApiOperation(value = "Find sale car", notes = "Return sale car by id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SaleCarModel getCar(@PathVariable Integer id) {
		return scService.getSaleCar(id);
	}

	/**
	 * json input = 
	 	{"carId":"2","optionalParts":["ABS","LL","TC"]}
	 * @param sci
	 * @return
	 */
	@ApiOperation(value = "Update or create a sale car", notes = "Update or create a sale car")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@Valid 
			@ApiParam(
					required = true,
					value = "{\"carId\":\"2\","
							+ "\"optionalParts\":"
							+ "["
							+ "\"ABS\",\"LL\",\"TC\""
							+ "]"
							+ "}" ,
					examples = @io.swagger.annotations.Example(
							value = {
									@ExampleProperty(
											value="{\"carId\":\"2\","
													+ "\"optionalParts\":"
													+ "["
													+ "\"ABS\",\"LL\",\"TC\""
													+ "]"
													+ "}"
									)
							}
					)
			)
			@RequestBody String input) {
		ResponseEntity<?> result;
		SaleCarInputModel sci = null;
		ObjectMapper map = new ObjectMapper();
		
		try
		{
			sci = map.readValue(input, SaleCarInputModel.class);
			result = scb.update(sci);
		}
		catch (Exception e) {
			result = CustomJsonParseException.getResponse();
		}
		
		return result;
	}

	@ApiOperation(value = "Delete sale car", notes = "Delete a sale car by id")
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		 scService.deleteById(id);
		 return new ResponseEntity<>("Registro eliminado", HttpStatus.ACCEPTED);
	}

}
