package com.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args) 
	{
	    Configuration conn=new Configuration().configure().addAnnotatedClass(Player.class).addAnnotatedClass(Game.class);
	    ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conn.getProperties()).buildServiceRegistry();
	    SessionFactory sf=conn.buildSessionFactory(reg);
	    Session sess=sf.openSession();
	    Transaction tx=sess.beginTransaction();
	    Game g1=new Game(1,"cricket");
	    sess.save(g1);
	    Game g2=new Game(2,"running");
	    sess.save(g2);
	    Game g3=new Game(3,"football");
	    sess.save(g3);
	    Set<Game> games=new HashSet<Game>(Arrays.asList(g1,g2,g3));
	    Player p1=new Player(1,"sai");
	    p1.setGameList(games);
	    Set<Game> games1=new HashSet<Game>(Arrays.asList(g2,g3));
	    Player p2=new Player(2,"senthil");
	    p2.setGameList(games1);
	    sess.save(p1);
	    sess.save(p2);
	    tx.commit();
	    sess.clear();

	}

}
