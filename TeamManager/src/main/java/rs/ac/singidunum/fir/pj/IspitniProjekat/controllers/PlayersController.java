package rs.ac.singidunum.fir.pj.IspitniProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.fir.pj.IspitniProjekat.entities.Manager;
import rs.ac.singidunum.fir.pj.IspitniProjekat.entities.Player;
import rs.ac.singidunum.fir.pj.IspitniProjekat.repositories.PlayersRepository;

@CrossOrigin
@RestController
public class PlayersController {

	@Autowired
	private PlayersRepository repository; 
	
	// treba da okida na GET na localhost:8085/players
	@GetMapping("/players")
	public List<Player> getAllPlayers() {
		return (List<Player>)repository.findAll();
	}
	
	// treba da okida na GET na localhost:8085/players/{id}
	@GetMapping("/players/{id}")
	public Player getOnePlayer(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	// kreira novog igraca 
	@PostMapping(path="/players")
	public Player createOnePlayer(@RequestBody Player player) {
		return repository.save(player);
	}
	
	// brise igraca preko id-a
	@DeleteMapping("/players/{id}")
	public void deletePlayer(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	// azuriranje 
	@PutMapping("/players/{id}")
	public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
		return repository.save(player); 
	}
	
	// GET na rutu localhost:8085/players/search/{name}
	// trazi igraca po imenu 
	@GetMapping("/players/search/{name}")
	public Player findPlayerByName(@PathVariable String name) {
		return repository.findByName(name);
	}

	// dohvatanje svih igraca koji imaju istog menadzera
	@GetMapping("/players/manager")
	public List<Player> nadjiIgracePoMenadzeru(@RequestBody Manager manager) {
		return repository.findAllPlayersByManagers(manager);
	}
 
	
	
	
}
