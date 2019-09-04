package ar.com.jorgerojasdeveloper.sysoneapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.jorgerojasdeveloper.sysoneapplication.entities.SaleCar;

public interface ISaleCarRepository extends JpaRepository<SaleCar, Integer> {
	SaleCar findByCarId( Integer car_id );
}
