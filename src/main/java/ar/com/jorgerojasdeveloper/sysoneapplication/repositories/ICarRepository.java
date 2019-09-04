package ar.com.jorgerojasdeveloper.sysoneapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.com.jorgerojasdeveloper.sysoneapplication.entities.Car;

public interface ICarRepository extends JpaRepository<Car, Integer> {

}
