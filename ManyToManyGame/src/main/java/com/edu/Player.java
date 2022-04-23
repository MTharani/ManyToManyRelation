package com.edu;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="myplayer")
public class Player 
{
	@Id
	@Column(name="pid")
	private int id;
	@Column(name="pname",length=30)
	private String name;
	//constructor with argument
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	//constructor without argument
	public Player() {
		super();
	}
@ManyToMany
	Set<Game>GameList;
@JoinTable(name="myplayer_mygame",
joinColumns = {@JoinColumn(name="id",referencedColumnName = "pid")},
inverseJoinColumns = {@JoinColumn(name="id",referencedColumnName = "gid")})
//getter and setter
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
public Set<Game> getGameList() {
	return GameList;
}
public void setGameList(Set<Game> gameList) {
	GameList = gameList;
}
//to string
@Override
public String toString() {
	return "Player [id=" + id + ", name=" + name + ", GameList=" + GameList + "]";
}


		                          

            

}
