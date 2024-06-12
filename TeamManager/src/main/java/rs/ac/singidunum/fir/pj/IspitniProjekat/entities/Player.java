package rs.ac.singidunum.fir.pj.IspitniProjekat.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.JoinColumn;

@CrossOrigin
@Entity
@Table(name = "players")
public class Player {

	@Id
	private int id; 
	
	private String name; 
	private String club;
	private String price; 
	private int age;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "playersmanagers", 
		joinColumns = @JoinColumn(name = "players_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "managers_id", referencedColumnName = "id")
	)
	private Set<Manager> managers; 
	
	@ManyToMany(mappedBy = "players")
	private Set<Manager> menadzeri;
	
	
	public Player(int id, String name, String club, String price, int age) {
		this.id = id;
		this.name = name;
		this.club = club;
		this.price = price;
		this.age = age;
	}
	
	public Player() {} // podrazumevani konstruktor 

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


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", club=" + club + ", price=" + price + ", age=" + age + "]";
	}
	
	
	
}
