package rs.ac.singidunum.fir.pj.IspitniProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.fir.pj.IspitniProjekat.entities.Manager;
import rs.ac.singidunum.fir.pj.IspitniProjekat.repositories.ManagersRepository;

@RestController
public class ManagersController {

	@Autowired
	private ManagersRepository repository; 
	
	// treba da okida na GET na localhost:8085/managers
	@GetMapping("/managers")
	public List<Manager> getAll() {
		return (List<Manager>)repository.findAll();
	}
	
	// treba da okida na GET na localhost:8085/managers/{id}
	@GetMapping("/managers/{id}")
	public Manager getOne(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	@PostMapping(path="/managers")
	public Manager createOne(@RequestBody Manager manager) {
		return repository.save(manager);
	}
	
	@DeleteMapping("/managers/{id}")
	public void deleteManager(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/managers/{id}")
	public Manager updateManager(@PathVariable int id, @RequestBody Manager manager) {
		return repository.save(manager); 
	}
	
}
