package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.BoardKB;
import domain.CardKB;
import domain.ColoredTagKB;
import domain.ColumnKB;
import domain.TagKB;
import domain.UserKB;

/**
 * jdbc:hsqldb:hsql://localhost/
 * 
 * @author nrichard dbouillet
 *
 */
public class JpaEtienne {

	private EntityManager manager;

	public JpaEtienne(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		JpaEtienne jpa = new JpaEtienne(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			jpa.populate();
//			jpa.listCards();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		factory.close();
	}

	private void populate() {
		int nb = manager.createQuery("select b from KBBoard b", BoardKB.class).getResultList().size();

		if (nb == 0) {

			BoardKB board = new BoardKB();
			board.setName("Board");

			ColumnKB col1 = new ColumnKB("TODO");
			ColumnKB col2 = new ColumnKB("DOING");
			ColumnKB col3 = new ColumnKB("DONE");

			board.addColumn(col1);
			board.addColumn(col2);
			board.addColumn(col3);

			UserKB user1 = new UserKB("Jean", "Bon", "beurre@mail.fr");
			UserKB user2 = new UserKB("Jean", "Aimarre", "tartine@mail.fr");

			CardKB card1 = new CardKB("ranger", "une maison rangée c'est bien", 30, "maison.com", "maison");
			card1.setAssignedUser(user1);
			CardKB card2 = new CardKB("faire à manger", "manger c'est bon des fois", 45, "cuisine.net", "cuisine");
			card2.setAssignedUser(user2);

			col1.addCard(card1);
			col1.addCard(card2);
			
			ColoredTagKB ctag = new ColoredTagKB();
			ctag.setColor("red");
			ctag.setLabel("I'm a red tag");
			
			TagKB tag = new TagKB();
			tag.setLabel("I'm a sad tag with no color");
			
			manager.persist(tag);
			
			manager.persist(ctag);

			manager.persist(user1);
			manager.persist(user2);

			manager.persist(board);
		}
	}
	
	private void listCards() {
		List<CardKB> resultList = manager.createQuery("Select c From Card c", CardKB.class).getResultList();
		
		System.out.println("num of cards:" + resultList.size());
		for (CardKB next : resultList) {
			System.out.println("next card: " + next);
		}
	}

}
