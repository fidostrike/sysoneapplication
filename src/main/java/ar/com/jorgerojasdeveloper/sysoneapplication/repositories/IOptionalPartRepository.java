package ar.com.jorgerojasdeveloper.sysoneapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.jorgerojasdeveloper.sysoneapplication.entities.OptionalPart;

public interface IOptionalPartRepository extends JpaRepository<OptionalPart, Integer> {

	OptionalPart findByAbbrev(String abbrev);

}
