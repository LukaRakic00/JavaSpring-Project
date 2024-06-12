package rs.ac.singidunum.fir.pj.IspitniProjekat.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="managers")
public class Manager {

	@Id
	private int id; 
	
	private String name; 
	private String club;
	private int age;
	
	@ManyToMany(mappedBy = "managers")
	private Set<Player> players;
	
	public Manager(int id, String name, String club, int age) {
		this.id = id;
		this.name = name;
		this.club = club;
		this.age = age;
	}
	
	public Manager() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", club=" + club + ", age=" + age + "]";
	} 
	
	
	
	
}
