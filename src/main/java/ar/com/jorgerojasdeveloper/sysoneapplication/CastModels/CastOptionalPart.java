package ar.com.jorgerojasdeveloper.sysoneapplication.CastModels;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ar.com.jorgerojasdeveloper.sysoneapplication.entities.OptionalPart;
import ar.com.jorgerojasdeveloper.sysoneapplication.models.OptionalPartModel;

@Component
public class CastOptionalPart {
	public List<OptionalPartModel> entityToModelList(List<OptionalPart> op) {
		return op.stream().map(item -> this.entityToModel(item)).collect(Collectors.toList());
	}

	public OptionalPartModel entityToModel(OptionalPart op) {
		OptionalPartModel model = new OptionalPartModel();

		model.setId(op.getId());
		model.setName(op.getName());
		model.setPrice(op.getPrice());
		model.setAbbrev(op.getAbbrev());

		return model;

	}
}
