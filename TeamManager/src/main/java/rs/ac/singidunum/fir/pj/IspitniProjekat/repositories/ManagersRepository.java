package rs.ac.singidunum.fir.pj.IspitniProjekat.repositories;

import org.springframework.data.repository.CrudRepository;

import rs.ac.singidunum.fir.pj.IspitniProjekat.entities.Manager;

public interface ManagersRepository extends CrudRepository<Manager, Integer> {

	Manager findByAge(int age);
	
}
