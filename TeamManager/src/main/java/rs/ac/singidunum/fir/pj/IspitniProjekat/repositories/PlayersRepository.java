package rs.ac.singidunum.fir.pj.IspitniProjekat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import rs.ac.singidunum.fir.pj.IspitniProjekat.entities.Manager;
import rs.ac.singidunum.fir.pj.IspitniProjekat.entities.Player;

public interface PlayersRepository extends CrudRepository<Player, Integer>{

	Player findByName(String name);
	
	Player findByNameIgnoreCase(String name);
	
	List<Player> findAllPlayersByManagers(Manager manager);
	
}
