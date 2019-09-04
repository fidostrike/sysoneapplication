package ar.com.jorgerojasdeveloper.sysoneapplication.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.com.jorgerojasdeveloper.sysoneapplication.CastModels.CastOptionalPart;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.OptionalPart;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.OptionalPartModel;
import ar.com.jorgerojasdeveloper.sysoneapplication.repositories.IOptionalPartRepository;

@Service
public class OptionalPartService implements IOptionalPartService {
	@Autowired
	IOptionalPartRepository opRep;
	
	@Autowired
	CastOptionalPart castOp;

	public List<OptionalPartModel> getAllOptionalParts() {
		return castOp.entityToModelList((List<OptionalPart>)opRep.findAll());
	}

	public OptionalPartModel getOptionalPart(Integer id) {
		return castOp.entityToModel((opRep.getOne(id)));
	}
	
	public OptionalPartModel getOptionalPartByAbbrev(String abbrev) {
		return castOp.entityToModel((opRep.findByAbbrev(abbrev)));
	}
	
	public OptionalPart findByAbbrev(String abbrev) {
		return opRep.findByAbbrev(abbrev);
	}
	
	public <S extends OptionalPart> S save(S entity) {
		return opRep.save(entity);
	}

	public List<OptionalPart> findAll() {
		return opRep.findAll();
	}
	
}
