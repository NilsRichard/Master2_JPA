package jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.UserKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public class JpaTest {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {

//			Board table = new Board("FirstTable");
//
//			table.addColumn(new Column("TODO"));
//			table.addColumn(new Column("DOING"));
//			table.addColumn(new Column("DONE"));
//
//			manager.persist(table);

            UserKB user = new UserKB();
            user.setEmail("beurre@mail.fr");
            user.setFirstName("Jean");
            user.setLastName("Bon");

            UserKB user2 = new UserKB();
            user2.setEmail("tartine@mail.fr");
            user2.setFirstName("Jean");
            user2.setLastName("Aimarre");

            manager.persist(user);
            manager.persist(user2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }


}
