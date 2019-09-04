package ar.com.jorgerojasdeveloper.sysoneapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.OptionalPartModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.services.OptionalPartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Optional part controller", description = "This API is to find optional parts")
@RestController
@RequestMapping(path="/optionalpart")
public class OptionalPartController {
	@Autowired
	OptionalPartService opService;
	
	@ApiOperation(value = "Find optional parts", notes = "Return all list of optional parts")
	@GetMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<OptionalPartModel> listOptionalParts(){
        return opService.getAllOptionalParts();
    }
	
	@ApiOperation(value = "Find optional part", notes = "Return optional part by id")
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public OptionalPartModel getOptionalPart(@PathVariable Integer id){
        return opService.getOptionalPart(id);
    }
	
}
