package com.edu;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="mygame")
public class Game 
{
	@Id
  @Column(name="gid")
   private int id;
  @Column(name="gname",length=30)
   private String name;
  
  //constructor with argument
  public Game(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
  //constructor without argument

public Game() {
	super();
}
//many to many relation
@ManyToMany(mappedBy = "GameList")
  Set<Player>playerlist;
//geter and setter
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

public Set<Player> getPlayerlist() {
	return playerlist;
}

public void setPlayerlist(Set<Player> playerlist) {
	this.playerlist = playerlist;
}
//to string
@Override
public String toString() {
	return "Game [id=" + id + ", name=" + name + ", playerlist=" + playerlist + "]";
}

}
