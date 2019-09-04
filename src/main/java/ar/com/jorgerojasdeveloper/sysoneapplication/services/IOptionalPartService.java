package ar.com.jorgerojasdeveloper.sysoneapplication.services;

import java.util.List;

import ar.com.jorgerojasdeveloper.sysoneapplication.entities.OptionalPart;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.OptionalPartModel;

public interface IOptionalPartService {
	public List<OptionalPartModel> getAllOptionalParts();
	
	public OptionalPartModel getOptionalPart(Integer id);
	
	public OptionalPartModel getOptionalPartByAbbrev(String abbrev);
	
	public OptionalPart findByAbbrev(String abbrev);
	
	public <S extends OptionalPart> S save(S entity);
	
	public List<OptionalPart> findAll();
}
